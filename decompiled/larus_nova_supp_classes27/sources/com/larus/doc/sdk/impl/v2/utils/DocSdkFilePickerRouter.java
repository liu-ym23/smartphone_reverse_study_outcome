package com.larus.doc.sdk.impl.v2.utils;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.config.CommonAlbumMediaMode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.OutputParam;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J,\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0002J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001c0.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/utils/DocSdkFilePickerRouter;", "", "<init>", "()V", "TAG", "", "BRIDGE_TAG", "DEFAULT_ALBUM_SPAN_COUNT", "", "DEFAULT_MAX_SELECT_COUNT", "openAlbum", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "request", "Lcom/bytedance/ee/bear/config/CommonAlbumRequest;", "callback", "Lcom/bytedance/ee/bear/config/CommonFilePickerCallback;", "openCamera", "Lcom/bytedance/ee/bear/config/CommonCameraRequest;", "showFileSelector", "Lcom/bytedance/ee/bear/config/CommonFileSelectorRequest;", "withBridgeFragment", "action", "Lkotlin/Function1;", "Lcom/larus/doc/sdk/impl/v2/utils/DocSdkFilePickerRouter$FilePickerBridgeFragment;", "getOrCreateBridgeFragment", "buildCommonFileBean", "Lcom/bytedance/ee/bear/config/CommonFileBean;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "albumItem", "Lcom/larus/platform/model/album/AlbumSelectItem;", "path", "resolveFilePath", "resolveFileSize", "", "copyContentUriToCache", "resolveMimeType", "fallback", "logCommonFileBeansIfDebug", "type", "id", "files", "", "FilePickerBridgeFragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSdkFilePickerRouter {
    private static final String BRIDGE_TAG = "doc_sdk_file_picker_router_bridge";
    private static final int DEFAULT_ALBUM_SPAN_COUNT = 4;
    private static final int DEFAULT_MAX_SELECT_COUNT = 10;
    public static final DocSdkFilePickerRouter INSTANCE = null;
    private static final String TAG = "DocSdkFilePickerRouter";

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0&2\b\u0010,\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010-\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\r2\u001a\u0010.\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u0001000/0&2\u0006\u00101\u001a\u00020!H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/utils/DocSdkFilePickerRouter$FilePickerBridgeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "requestIdGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "inFlight", "Lcom/larus/doc/sdk/impl/v2/utils/DocSdkFilePickerRouter$FilePickerBridgeFragment$InFlightRequest;", "fileSelectorLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openAlbum", "request", "Lcom/bytedance/ee/bear/config/CommonAlbumRequest;", "callback", "Lcom/bytedance/ee/bear/config/CommonFilePickerCallback;", "openCamera", "Lcom/bytedance/ee/bear/config/CommonCameraRequest;", "showFileSelector", "_request", "Lcom/bytedance/ee/bear/config/CommonFileSelectorRequest;", "beginRequest", "type", "", "finishRequest", "id", "", "files", "", "Lcom/bytedance/ee/bear/config/CommonFileBean;", "canceled", "", "extractUris", "Landroid/net/Uri;", "data", "handleUrisAsync", "items", "Lkotlin/Pair;", "Lcom/larus/platform/model/album/AlbumSelectItem;", "scene", "InFlightRequest", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FilePickerBridgeFragment extends Fragment {
        private final Lazy albumHelper$delegate;
        private final ActivityResultLauncher<Intent> fileSelectorLauncher;
        private InFlightRequest inFlight;
        private final AtomicLong requestIdGenerator;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/utils/DocSdkFilePickerRouter$FilePickerBridgeFragment$InFlightRequest;", "", "id", "", "type", "", "callback", "Lcom/bytedance/ee/bear/config/CommonFilePickerCallback;", "canceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(JLjava/lang/String;Lcom/bytedance/ee/bear/config/CommonFilePickerCallback;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getId", "()J", "getType", "()Ljava/lang/String;", "getCallback", "()Lcom/bytedance/ee/bear/config/CommonFilePickerCallback;", "getCanceled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class InFlightRequest {
            private final ew4.m callback;
            private final AtomicBoolean canceled;
            private final long id;
            private final String type;

            public static /* synthetic */ InFlightRequest copy$default(InFlightRequest r6, long r7, String r9, ew4.m r10, AtomicBoolean r11, int r12, Object r13) {
                if ((r12 & 1) == 0) goto L5;
                r7 = r6.id;
            L5:
                long r1 = r7;
                if ((r12 & 2) == 0) goto L8;
                r9 = r6.type;
            L8:
                String r3 = r9;
                if ((r12 & 4) == 0) goto L11;
                r10 = r6.callback;
            L11:
                ew4.m r4 = r10;
                if ((r12 & 8) == 0) goto L15;
                r11 = r6.canceled;
            L15:
                return r6.copy(r1, r3, r4, r11);
            }

            public final long component1() {
                return this.id;
            }

            public final String component2() {
                return this.type;
            }

            public final ew4.m component3() {
                return this.callback;
            }

            public final AtomicBoolean component4() {
                return this.canceled;
            }

            public final InFlightRequest copy(long r8, String r10, ew4.m r11, AtomicBoolean r12) {
                Intrinsics.checkNotNullParameter(r10, "type");
                Intrinsics.checkNotNullParameter(r11, "callback");
                Intrinsics.checkNotNullParameter(r12, "canceled");
                return new InFlightRequest(r8, r10, r11, r12);
            }

            public boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof InFlightRequest) == true) goto L8;
                return false;
            L8:
                InFlightRequest r9 = (InFlightRequest) r8;
                if (this.id == r9.id) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.type, r9.type) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.callback, r9.callback) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.canceled, r9.canceled) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                long r0 = this.id;
                return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.type.hashCode()) * 31) + this.callback.hashCode()) * 31) + this.canceled.hashCode();
            }

            public String toString() {
                return "InFlightRequest(id=" + this.id + ", type=" + this.type + ", callback=" + this.callback + ", canceled=" + this.canceled + ')';
            }

            public final ew4.m getCallback() {
                return this.callback;
            }

            public final AtomicBoolean getCanceled() {
                return this.canceled;
            }

            public final long getId() {
                return this.id;
            }

            public final String getType() {
                return this.type;
            }

            public InFlightRequest(long r2, String r4, ew4.m r5, AtomicBoolean r6) {
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "callback");
                Intrinsics.checkNotNullParameter(r6, "canceled");
                this.id = r2;
                this.type = r4;
                this.callback = r5;
                this.canceled = r6;
            }

            public /* synthetic */ InFlightRequest(long r7, String r9, ew4.m r10, AtomicBoolean r11, int r12, DefaultConstructorMarker r13) {
                if ((r12 & 8) == 0) goto L5;
                r11 = new AtomicBoolean(false);
            L5:
                this(r7, r9, r10, r11);
            }
        }

        public static /* synthetic */ Unit S90(FilePickerBridgeFragment r0) {
            return onCreate$lambda$10(r0);
        }

        public static /* synthetic */ Unit T90() {
            return openAlbum$lambda$11();
        }

        public static /* synthetic */ Unit U90(FilePickerBridgeFragment r0) {
            return openAlbum$lambda$12(r0);
        }

        public static /* synthetic */ Unit V90(FilePickerBridgeFragment r0, CameraOutputContext r1) {
            return onCreate$lambda$9(r0, r1);
        }

        public static /* synthetic */ void W90(FilePickerBridgeFragment r0, ActivityResult r1) {
            fileSelectorLauncher$lambda$2(r0, r1);
        }

        public static /* synthetic */ void X90(InFlightRequest r0, List r1, Context r2, String r3, FilePickerBridgeFragment r4) {
            handleUrisAsync$lambda$22(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Unit Y90(FilePickerBridgeFragment r0, xp9.i r1) {
            return onCreate$lambda$7(r0, r1);
        }

        public static /* synthetic */ void Z90(String r0, List r1, InFlightRequest r2, FilePickerBridgeFragment r3) {
            handleUrisAsync$lambda$22$lambda$21(r0, r1, r2, r3);
        }

        public static /* synthetic */ AlbumHelper aa0() {
            return albumHelper_delegate$lambda$0();
        }

        public static /* synthetic */ Unit ba0(FilePickerBridgeFragment r0, AlbumSelectItem r1) {
            return onCreate$lambda$3(r0, r1);
        }

        private static final AlbumHelper albumHelper_delegate$lambda$0() {
            return new AlbumHelper();
        }

        private final AlbumHelper getAlbumHelper() {
            return (AlbumHelper) this.albumHelper$delegate.getValue();
        }

        public FilePickerBridgeFragment() {
            this.albumHelper$delegate = LazyKt.lazy(new e());
            this.requestIdGenerator = new AtomicLong(0);
            this.fileSelectorLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(this));
        }

        private static final Unit openAlbum$lambda$11() {
            return Unit.INSTANCE;
        }

        private final List<Uri> extractUris(Intent r5) {
            ArrayList r0 = new ArrayList();
            if (r5 == null) goto L7;
            Uri r1 = r5.getData();
            if (r1 == null) goto L7;
            r0.add(r1);
        L7:
            if (r5 == null) goto L9;
            ClipData r6 = r5.getClipData();
        L10:
            if (r6 == null) goto L20;
            int r2 = r6.getItemCount();
            int r3 = 0;
        L12:
            if (r3 >= r2) goto L20;
            ClipData.Item r4 = r6.getItemAt(r3);
            if (r4 == null) goto L18;
            Uri r7 = r4.getUri();
            if (r7 == null) goto L18;
            r0.add(r7);
        L18:
            r3 = r3 + 1;
        L20:
            return CollectionsKt.distinct(r0);
        L9:
            r6 = null;
            goto L10
        }

        private static final Unit onCreate$lambda$10(FilePickerBridgeFragment r9) {
            InFlightRequest r0 = r9.inFlight;
            if (r0 != null) goto L5;
        L9:
            FLogger r10 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[openCamera] ignore fail, currentType=");
            if (r0 == null) goto L12;
            String r2 = r0.getType();
        L13:
            r1.append(r2);
            r10.i(DocSdkFilePickerRouter.TAG, r1.toString());
            return Unit.INSTANCE;
        L12:
            r2 = null;
            goto L13
        L5:
            if (Intrinsics.areEqual(r0.getType(), "openCamera") == false) goto L9;
            finishRequest$default(r9, r0.getId(), null, true, 2, null);
            return Unit.INSTANCE;
        }

        private static final Unit openAlbum$lambda$12(FilePickerBridgeFragment r7) {
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[openAlbum] takeByAlbum fail");
            InFlightRequest r0 = r7.inFlight;
            if (r0 == null) goto L5;
            finishRequest$default(r7, r0.getId(), null, true, 2, null);
            return Unit.INSTANCE;
        L5:
            return Unit.INSTANCE;
        }

        public void onCreate(Bundle r3) {
            super.onCreate(r3);
            AlbumHelper r4 = getAlbumHelper();
            Function1 r0 = new g(this);
            Lazy r1 = AlbumHelper.e;
            r4.b(this, "album_helper", r0);
            getAlbumHelper().e(this, "album_helper", new h(this));
            IFlowCamera r5 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
            if (r5 == null) goto L6;
            r5.m(this, new i(this), new j(this));
            return;
        }

        private final void beginRequest(String r10, ew4.m r11) {
            long r2 = this.requestIdGenerator.incrementAndGet();
            InFlightRequest r0 = this.inFlight;
            if (r0 == null) goto L5;
            r0.getCanceled().set(true);
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "beginRequest cancel previous type=" + r0.getType() + ", id=" + r0.getId() + ", nextType=" + r10 + ", nextId=" + r2);
            r0.getCallback().onCancel();
        L5:
            this.inFlight = new InFlightRequest(r2, r10, r11, null, 8, null);
        }

        private static final void fileSelectorLauncher$lambda$2(FilePickerBridgeFragment r12, ActivityResult r13) {
            InFlightRequest r0 = r12.inFlight;
            String r1 = null;
            if (r0 != null) goto L5;
        L21:
            FLogger r14 = FLogger.a;
            StringBuilder r3 = new StringBuilder("[showFileSelector] ignore result, currentType=");
            if (r0 == null) goto L24;
            r1 = r0.getType();
        L24:
            r3.append(r1);
            r3.append(", code=");
            r3.append(r13.getResultCode());
            r14.i(DocSdkFilePickerRouter.TAG, r3.toString());
            return;
        L5:
            if (Intrinsics.areEqual(r0.getType(), "showFileSelector") == false) goto L21;
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[showFileSelector] onResult code=" + r13.getResultCode() + ", data=" + r13.getData());
            if (r13.getResultCode() == (-1)) goto L11;
            finishRequest$default(r12, r0.getId(), null, true, 2, null);
            return;
        L11:
            List<Uri> r15 = r12.extractUris(r13.getData());
            if (r15.isEmpty() == false) goto L15;
            finishRequest$default(r12, r0.getId(), null, true, 2, null);
            return;
        L15:
            List<Uri> r16 = r15;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r17 = r16.iterator();
        L17:
            if (r17.hasNext() == false) goto L19;
            r2.add(TuplesKt.to((Uri) r17.next(), null));
            goto L17
        L19:
            r12.handleUrisAsync(r0, r2, "showFileSelector");
        }

        private static final Unit onCreate$lambda$3(FilePickerBridgeFragment r12, AlbumSelectItem r13) {
            Intrinsics.checkNotNullParameter(r13, "item");
            InFlightRequest r0 = r12.inFlight;
            if (r0 != null) goto L5;
        L13:
            FLogger r14 = FLogger.a;
            StringBuilder r15 = new StringBuilder("[openAlbum] ignore single result, currentType=");
            if (r0 == null) goto L16;
            String r1 = r0.getType();
        L17:
            r15.append(r1);
            r14.i(DocSdkFilePickerRouter.TAG, r15.toString());
            return Unit.INSTANCE;
        L16:
            r1 = null;
            goto L17
        L5:
            if (Intrinsics.areEqual(r0.getType(), "openAlbum") == false) goto L13;
            Uri r2 = r13.a;
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[openAlbum] single onResult uri=" + r2);
            if (r2 != null) goto L11;
            finishRequest$default(r12, r0.getId(), null, true, 2, null);
            return Unit.INSTANCE;
        L11:
            r12.handleUrisAsync(r0, CollectionsKt.listOf(TuplesKt.to(r2, r13)), "openAlbum.single");
            return Unit.INSTANCE;
        }

        private static final Unit onCreate$lambda$7(FilePickerBridgeFragment r10, xp9.i r11) {
            Intrinsics.checkNotNullParameter(r11, "multiConfig");
            InFlightRequest r0 = r10.inFlight;
            String r2 = null;
            if (r0 != null) goto L5;
        L43:
            FLogger r12 = FLogger.a;
            StringBuilder r13 = new StringBuilder("[openAlbum] ignore multi result, currentType=");
            if (r0 == null) goto L46;
            r2 = r0.getType();
        L46:
            r13.append(r2);
            r12.i(DocSdkFilePickerRouter.TAG, r13.toString());
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r0.getType(), "openAlbum") == false) goto L43;
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("[openAlbum] multi onResult reasonSend=");
            r4.append(r11.d);
            r4.append(", uriCount=");
            r4.append(r11.a.size());
            r4.append(", itemCount=");
            List r5 = r11.c;
            if (r5 == null) goto L10;
            Integer r6 = Integer.valueOf(r5.size());
        L11:
            r4.append(r6);
            r3.i(DocSdkFilePickerRouter.TAG, r4.toString());
            if (r11.d == false) goto L15;
            finishRequest$default(r10, r0.getId(), null, true, 2, null);
            return Unit.INSTANCE;
        L15:
            List r1 = r11.c;
            List r7 = r1;
            if (r7 != null) goto L18;
        L21:
            boolean r8 = true;
        L22:
            if (r8 == true) goto L32;
            ArrayList r14 = new ArrayList();
            Iterator r9 = r1.iterator();
        L25:
            if (r9.hasNext() == false) goto L38;
            AlbumSelectItem r15 = (AlbumSelectItem) r9.next();
            Uri r16 = r15.a;
            if (r16 == null) goto L29;
            Pair r17 = TuplesKt.to(r16, r15);
        L30:
            if (r17 == null) goto L25;
            r14.add(r17);
            goto L25
        L29:
            r17 = null;
        L38:
            if (r14.isEmpty() == false) goto L41;
            finishRequest$default(r10, r0.getId(), null, true, 2, null);
            return Unit.INSTANCE;
        L41:
            r10.handleUrisAsync(r0, r14, "openAlbum.multi");
            return Unit.INSTANCE;
        L32:
            List r18 = r11.a;
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
            Iterator r110 = r18.iterator();
        L34:
            if (r110.hasNext() == false) goto L36;
            r20.add(TuplesKt.to((Uri) r110.next(), null));
            goto L34
        L36:
            r14 = r20;
            goto L38
        L18:
            if (r7.isEmpty() == true) goto L21;
            r8 = false;
            goto L22
        L10:
            r6 = null;
            goto L11
        }

        private static final Unit onCreate$lambda$9(FilePickerBridgeFragment r13, CameraOutputContext r14) {
            Intrinsics.checkNotNullParameter(r14, "result");
            InFlightRequest r0 = r13.inFlight;
            String r1 = null;
            if (r0 != null) goto L5;
        L34:
            FLogger r15 = FLogger.a;
            StringBuilder r16 = new StringBuilder("[openCamera] ignore result, currentType=");
            if (r0 == null) goto L37;
            r1 = r0.getType();
        L37:
            r16.append(r1);
            r15.i(DocSdkFilePickerRouter.TAG, r16.toString());
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r0.getType(), "openCamera") == false) goto L34;
            List r17 = r14.getOutputParamList();
            if (r17 != null) goto L10;
            r17 = CollectionsKt.emptyList();
        L10:
            ArrayList r5 = new ArrayList();
            Iterator r18 = r17.iterator();
        L12:
            if (r18.hasNext() == false) goto L29;
            OutputParam r2 = (OutputParam) r18.next();
            if (r2 == null) goto L16;
            String r3 = r2.getPath();
        L17:
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            String r10 = r3;
            if (r10.length() != 0) goto L22;
            boolean r4 = true;
        L23:
            if (r4 == false) goto L25;
            ew4.l r6 = null;
        L26:
            if (r6 == null) goto L12;
            r5.add(r6);
            goto L12
        L25:
            r6 = DocSdkFilePickerRouter.buildCommonFileBean$default(DocSdkFilePickerRouter.INSTANCE, r13.requireContext(), Uri.fromFile(new PolarisFileWrapper(r10)), null, r10, 4, null);
            goto L26
        L22:
            r4 = false;
            goto L23
        L16:
            r3 = null;
            goto L17
        L29:
            if (r5.isEmpty() == false) goto L31;
            finishRequest$default(r13, r0.getId(), null, true, 2, null);
        L33:
            return Unit.INSTANCE;
        L31:
            finishRequest$default(r13, r0.getId(), r5, false, 4, null);
            goto L33
        }

        public final void openAlbum(ew4.j r16, ew4.m r17) {
            Intrinsics.checkNotNullParameter(r16, "request");
            Intrinsics.checkNotNullParameter(r17, "callback");
            beginRequest("openAlbum", r17);
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[openAlbum] allowMultiple=" + r16.b + ", maxSelectCount=" + r16.c + ", mediaMode=" + r16.d);
            AlbumHelper r1 = getAlbumHelper();
            AlbumSettingConfig.a r2 = new AlbumSettingConfig.a();
            r2.g = Integer.valueOf(ContextCompat.getColor(requireContext(), 2131103292));
            boolean r3 = false;
            r2.e = false;
            boolean r4 = r16.b;
            r2.c = r4;
            if (r4 == false) goto L9;
            Integer r5 = r16.c;
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            int r7 = RangesKt.coerceAtLeast(r6, 1);
        L10:
            r2.d = r7;
            CommonAlbumMediaMode r0 = r16.d;
            if (r0 == CommonAlbumMediaMode.IMAGE_ONLY) goto L13;
            boolean r8 = true;
        L14:
            r2.i = r8;
            if (r0 != CommonAlbumMediaMode.VIDEO_ONLY) goto L17;
            r3 = true;
        L17:
            r2.r = r3;
            r2.h = 4;
            AlbumHelper.f(r1, this, r2.a(), new m(), new n(this), null, null, 0, null, null, null, Boolean.TRUE, null, 2048);
            return;
        L13:
            r8 = false;
            goto L14
        L7:
            r6 = 10;
            goto L8
        L9:
            r7 = 1;
            goto L10
        }

        public final void openCamera(ew4.k r37, ew4.m r38) {
            Intrinsics.checkNotNullParameter(r37, "request");
            Intrinsics.checkNotNullParameter(r38, "callback");
            if (r37.b == false) goto L5;
        L8:
            IFlowCamera r3 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
            if (r3 != null) goto L12;
            r38.onCancel();
            return;
        L12:
            beginRequest("openCamera", r38);
            boolean r1 = r37.c;
            HashMap r2 = new HashMap();
            r2.put("chat_key", 0L);
            JSONObject r4 = new JSONObject();
            r4.put("is_ai_doc", 1);
            Unit r5 = Unit.INSTANCE;
            r2.put("extra_params", r4);
            r3.r(this, new hx8.a("doc", "CAPTURE_MODE_PHOTO", null, r2, null, null, null, null, null, null, false, false, false, null, false, 0, r1, null, null, false, 0, null, false, false, false, null, null, null, null, 1040118768), null);
            return;
        L5:
            if (r37.c == true) goto L8;
            r38.onCancel();
        }

        public final void showFileSelector(ew4.n r8, ew4.m r9) {
            Intrinsics.checkNotNullParameter(r8, "_request");
            Intrinsics.checkNotNullParameter(r9, "callback");
            beginRequest("showFileSelector", r9);
            Intent r10 = new Intent();
            r10.setType("*/*");
            r10.setAction("android.intent.action.GET_CONTENT");
            r10.addCategory("android.intent.category.OPENABLE");
            r10.addFlags(1);
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[showFileSelector] launch");     // Catch: Throwable -> L5
            this.fileSelectorLauncher.launch(r10);     // Catch: Throwable -> L5
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L16;
            FLogger.a.e(DocSdkFilePickerRouter.TAG, "showFileSelector launch failed", r13);
            InFlightRequest r14 = this.inFlight;
            if (r14 == null) goto L17;
            finishRequest$default(this, r14.getId(), null, true, 2, null);
            return;
        L17:
            return;
        L16:
            return;
        L5:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        private final void finishRequest(long r6, List<ew4.l> r8, boolean r9) {
            InFlightRequest r0 = this.inFlight;
            Long r1 = null;
            if (r0 != null) goto L5;
        L16:
            FLogger r10 = FLogger.a;
            StringBuilder r11 = new StringBuilder("finishRequest ignored id=");
            r11.append(r6);
            r11.append(", currentId=");
            if (r0 == null) goto L19;
            r1 = Long.valueOf(r0.getId());
        L19:
            r11.append(r1);
            r10.i(DocSdkFilePickerRouter.TAG, r11.toString());
            return;
        L5:
            if (r0.getId() != r6) goto L16;
            this.inFlight = null;
            if (r9 == false) goto L10;
        L14:
            r0.getCallback().b();
            r0.getCallback().onCancel();
            return;
        L10:
            if (r0.getCanceled().get() == true) goto L14;
            r0.getCallback().b();
            DocSdkFilePickerRouter.access$logCommonFileBeansIfDebug(DocSdkFilePickerRouter.INSTANCE, r0.getType(), r0.getId(), r8);
            r0.getCallback().onSuccess(r8);
        }

        private final void handleUrisAsync(final InFlightRequest r8, final List<? extends Pair<? extends Uri, AlbumSelectItem>> r9, final String r10) {
            r8.getCallback().a();
            final Context r4 = requireContext().getApplicationContext();
            t0.a(new k(r8, r9, r4, r10, this));
        }

        private static final void handleUrisAsync$lambda$22$lambda$21(String r15, List r16, InFlightRequest r17, FilePickerBridgeFragment r18) {
            FLogger.a.i(DocSdkFilePickerRouter.TAG, "[" + r15 + "] processed count=" + r16.size() + ", canceled=" + r17.getCanceled().get() + ", id=" + r17.getId());
            if (r17.getCanceled().get() == false) goto L5;
        L8:
            finishRequest$default(r18, r17.getId(), null, true, 2, null);
            return;
        L5:
            if (r16.isEmpty() == true) goto L8;
            finishRequest$default(r18, r17.getId(), r16, false, 4, null);
        }

        private static final void handleUrisAsync$lambda$22(final InFlightRequest r10, List r11, Context r12, final String r13, final FilePickerBridgeFragment r14) {
            if (r10.getCanceled().get() == false) goto L5;
            final List r15 = CollectionsKt.emptyList();
        L15:
            t0.e(new l(r13, r15, r10, r14));
            return;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator r16 = r11.iterator();
        L7:
            if (r16.hasNext() == false) goto L14;
            Pair r1 = (Pair) r16.next();
            Uri r5 = (Uri) r1.component1();
            AlbumSelectItem r6 = (AlbumSelectItem) r1.component2();
            if (r10.getCanceled().get() == false) goto L11;
            ew4.l r2 = null;
        L12:
            if (r2 == null) goto L7;
            r0.add(r2);
            goto L7
        L11:
            DocSdkFilePickerRouter r3 = DocSdkFilePickerRouter.INSTANCE;
            Intrinsics.checkNotNull(r12);
            r2 = DocSdkFilePickerRouter.buildCommonFileBean$default(r3, r12, r5, r6, null, 8, null);
            goto L12
        L14:
            r15 = r0;
            goto L15
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void finishRequest$default(FilePickerBridgeFragment r0, long r1, List r3, boolean r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = CollectionsKt.emptyList();
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = false;
        L8:
            r0.finishRequest(r1, r3, r4);
        }
    }

    static {
        INSTANCE = new DocSdkFilePickerRouter();
    }

    private DocSdkFilePickerRouter() {
    }

    public static /* synthetic */ Unit a(ew4.j r0, ew4.m r1, FilePickerBridgeFragment r2) {
        return openAlbum$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(ew4.k r0, ew4.m r1, FilePickerBridgeFragment r2) {
        return openCamera$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ CharSequence c(ew4.l r0) {
        return logCommonFileBeansIfDebug$lambda$25(r0);
    }

    public static /* synthetic */ Unit d(ew4.n r0, ew4.m r1, FilePickerBridgeFragment r2) {
        return showFileSelector$lambda$2(r0, r1, r2);
    }

    private final FilePickerBridgeFragment getOrCreateBridgeFragment(FragmentActivity r4) {
        FragmentManager r5 = r4.getSupportFragmentManager();
        Fragment r1 = r5.findFragmentByTag(BRIDGE_TAG);
        if ((r1 instanceof FilePickerBridgeFragment) == false) goto L5;
        FilePickerBridgeFragment r2 = (FilePickerBridgeFragment) r1;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        FilePickerBridgeFragment r3 = new FilePickerBridgeFragment();
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r5.beginTransaction(), r3, BRIDGE_TAG).commitNowAllowingStateLoss();
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    private static final CharSequence logCommonFileBeansIfDebug$lambda$25(ew4.l r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        return "path=" + r3.a + ", mime=" + r3.b + ", w=" + r3.c + ", h=" + r3.d + ", size=" + r3.e + ", compress=" + r3.f + ", origin=" + r3.g;
    }

    private final String copyContentUriToCache(Context r16, Uri r17) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        Cursor r3 = com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_android_content_ContentResolver_query(r16.getContentResolver(), r17, new String[]{"_display_name"}, null, null, null);     // Catch: Throwable -> L25
        if (r3 == null) goto L22;
        Cursor r4 = r3;     // Catch: Throwable -> L25
        Cursor r5 = r4;     // Catch: Throwable -> L15
        if (r5.moveToFirst() == false) goto L12;
        int r0 = r5.getColumnIndex("_display_name");     // Catch: Throwable -> L15
        if (r0 < 0) goto L12;
        String r1 = r5.getString(r0);     // Catch: Throwable -> L15
    L13:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L25
    L23:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r6) == false) goto L30;
        r6 = null;
    L30:
        String r7 = (String) r6;
        boolean r8 = true;
        if (r7 != null) goto L33;
    L37:
        r7 = "doc_picker_" + System.currentTimeMillis();
    L38:
        String r9 = StringsKt.replace$default(StringsKt.replace$default(r7, "/", "_", false, 4, null), "\\", "_", false, 4, null);
        PolarisFileWrapper r10 = new PolarisFileWrapper(r16.getCacheDir(), "doc_picker_temp");
        r10.mkdirs();
        PolarisFileWrapper r11 = new PolarisFileWrapper(r10, r9);
        if (r11.exists() == false) goto L53;
        String r12 = FilesKt.getNameWithoutExtension(r11);
        String r13 = FilesKt.getExtension(r11);
        if (r13.length() > 0) goto L44;
        r8 = false;
    L44:
        if (r8 == true) goto L47;
        r13 = null;
    L47:
        if (r13 == null) goto L49;
        String r14 = ".".concat(r13);
    L50:
        if (r14 != null) goto L52;
        r14 = "";
    L52:
        r11 = new PolarisFileWrapper(r10, r12 + '_' + System.currentTimeMillis() + r14);
        goto L53
    L49:
        r14 = null;
    L53:
        InputStream r15 = ContentResolverWrapper.openInputStream(r16.getContentResolver(), r17);
        if (r15 != null) goto L78;
        return null;
    L78:
        PolarisFileOutputStreamWrapper r18 = new PolarisFileOutputStreamWrapper(r11);     // Catch: Throwable -> L68
        ByteStreamsKt.copyTo$default(r15, r18, 0, 2, null);     // Catch: Throwable -> L61
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r15, null);
        return r11.getAbsolutePath();
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L33:
        if ((!StringsKt.isBlank(r7)) == true) goto L36;
        r7 = null;
    L36:
        if (r7 != null) goto L38;
    L12:
        r1 = null;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L22:
        r1 = null;
    L25:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    private final String resolveFilePath(Context r4, Uri r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(r.j(r4, r5));     // Catch: Throwable -> L4
    L6:
        Object r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r3 = (String) r1;
        if (r3 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L19;
        return r3;
    L19:
        if (Intrinsics.areEqual(r5.getScheme(), "content") == true) goto L31;
        return null;
    L31:
        Object r7 = Result.constructor-impl(copyContentUriToCache(r4, r5));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r7) == true) goto L30;
        r2 = r7;
    L30:
        return (String) r2;
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L12:
        if (r3.length() == 0) goto L15;
        r6 = false;
    L4:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final long resolveFileSize(Context r11, Uri r12) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L51
        String r4 = r12.getScheme();     // Catch: Throwable -> L51
        if (r4 == null) goto L48;
        int r5 = r4.hashCode();     // Catch: Throwable -> L51
        if (r5 == 3143036) goto L42;
        if (r5 != 951530617) goto L48;
        if (r4.equals("content") == false) goto L48;
        Cursor r6 = com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_android_content_ContentResolver_query(r11.getContentResolver(), r12, new String[]{"_size"}, null, null, null);     // Catch: Throwable -> L51
        if (r6 == null) goto L31;
        Cursor r7 = r6;     // Catch: Throwable -> L51
        Cursor r8 = r7;     // Catch: Throwable -> L26
        if (r8.moveToFirst() == false) goto L23;
        int r0 = r8.getColumnIndex("_size");     // Catch: Throwable -> L26
        if (r0 < 0) goto L23;
        long r13 = RangesKt.coerceAtLeast(r8.getLong(r0), 0);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L51
    L49:
        Object r14 = Result.constructor-impl(Long.valueOf(r13));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r14) == false) goto L57;
        r14 = 0L;
    L57:
        return ((Number) r14).longValue();
    L23:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L51
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L31:
        ParcelFileDescriptor r15 = com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_android_content_ContentResolver_openFileDescriptor(r11.getContentResolver(), r12, "r");     // Catch: Throwable -> L51
        if (r15 == null) goto L48;
        long r9 = r15.getStatSize();     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L51
        r13 = RangesKt.coerceAtLeast(r9, 0);     // Catch: Throwable -> L51
        goto L49
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L42:
        if (r4.equals("file") == false) goto L48;
        String r16 = r12.getPath();     // Catch: Throwable -> L51
        if (r16 != null) goto L47;
        r16 = "";
    L47:
        r13 = new PolarisFileWrapper(r16).length();     // Catch: Throwable -> L51
    L48:
        r13 = 0;
    L51:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    private static ParcelFileDescriptor com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r110, String r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r110, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240020);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ParcelFileDescriptor) r4.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r18, r110, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private final void logCommonFileBeansIfDebug(String r10, long r11, List<ew4.l> r13) {
        String r14 = CollectionsKt.joinToString$default(r13, ", ", "[", "]", 0, null, new d(), 24, null);
        FLogger.a.d(TAG, "[" + r10 + "] onSuccess id=" + r11 + " files=" + r14);
    }

    private static final Unit openAlbum$lambda$0(ew4.j r1, ew4.m r2, FilePickerBridgeFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        r3.openAlbum(r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit openCamera$lambda$1(ew4.k r1, ew4.m r2, FilePickerBridgeFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        r3.openCamera(r1, r2);
        return Unit.INSTANCE;
    }

    private final String resolveMimeType(Context r4, Uri r5, String r6) {
        String r0 = r5.getScheme();
        if (r0 == null) goto L20;
        int r1 = r0.hashCode();
        if (r1 == 3143036) goto L13;
        if (r1 != 951530617) goto L20;
        if (r0.equals("content") == false) goto L20;
        String r7 = r4.getContentResolver().getType(r5);
    L21:
        if (r7 != null) goto L24;
        return r6;
    L24:
        return r7;
    L13:
        if (r0.equals("file") == false) goto L20;
        r7 = com.larus.office.base.utils.e.f(r5);
        if (r7.length() != 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
    L18:
        r8 = false;
    L20:
        r7 = null;
        goto L21
    }

    private static final Unit showFileSelector$lambda$2(ew4.n r1, ew4.m r2, FilePickerBridgeFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        r3.showFileSelector(r1, r2);
        return Unit.INSTANCE;
    }

    private final void withBridgeFragment(FragmentActivity r3, ew4.m r4, Function1<? super FilePickerBridgeFragment, Unit> r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(getOrCreateBridgeFragment(r3));     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.exceptionOrNull-impl(r6);
        if (r1 != null) goto L10;
        r5.invoke((FilePickerBridgeFragment) r6);
        return;
    L10:
        FLogger.a.e(TAG, "get bridge fragment failed", r1);
        r4.onCancel();
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void openAlbum(FragmentActivity r2, final ew4.j r3, final ew4.m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        withBridgeFragment(r2, r4, new c(r3, r4));
    }

    public final void openCamera(FragmentActivity r2, final ew4.k r3, final ew4.m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        withBridgeFragment(r2, r4, new b(r3, r4));
    }

    public final void showFileSelector(FragmentActivity r2, final ew4.n r3, final ew4.m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        withBridgeFragment(r2, r4, new a(r3, r4));
    }

    public static final /* synthetic */ void access$logCommonFileBeansIfDebug(DocSdkFilePickerRouter r0, String r1, long r2, List r4) {
        r0.logCommonFileBeansIfDebug(r1, r2, r4);
    }

    private final ew4.l buildCommonFileBean(Context r12, Uri r13, AlbumSelectItem r14, String r15) {
        Long r0 = null;
        if (r14 == null) goto L5;
        String r1 = r14.f;
    L6:
        String r4 = resolveMimeType(r12, r13, r1);
        boolean r2 = true;
        if (r4 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L65;
        Pair r5 = null;
    L22:
        if (r15 != null) goto L26;
        r15 = resolveFilePath(r12, r13);
        if (r15 != null) goto L26;
        r15 = r13.toString();
    L26:
        if (r14 == null) goto L36;
        Integer r6 = Integer.valueOf(r14.b);
        if (r6.intValue() <= 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L34;
        r6 = null;
    L34:
        if (r6 == null) goto L36;
        int r8 = r6.intValue();
    L39:
        if (r14 == null) goto L49;
        Integer r9 = Integer.valueOf(r14.c);
        if (r9.intValue() <= 0) goto L43;
        boolean r10 = true;
    L44:
        if (r10 == true) goto L47;
        r9 = null;
    L47:
        if (r9 == null) goto L49;
        int r11 = r9.intValue();
    L51:
        int r16 = r11;
    L53:
        if (r14 == null) goto L62;
        Long r17 = Long.valueOf(r14.e);
        if (r17.longValue() > 0) goto L58;
        r2 = false;
    L58:
        if (r2 == false) goto L60;
        r0 = r17;
    L60:
        if (r0 == null) goto L62;
        long r18 = r0.longValue();
    L64:
        return new ew4.l(r15, r4, r8, r16, r18);
    L62:
        r18 = resolveFileSize(r12, r13);
        goto L64
    L43:
        r10 = false;
    L49:
        if (r5 == null) goto L52;
        r11 = ((Number) r5.getSecond()).intValue();
        goto L51
    L52:
        r16 = 0;
        goto L53
    L30:
        r7 = false;
    L36:
        if (r5 == null) goto L38;
        r8 = ((Number) r5.getFirst()).intValue();
        goto L39
    L38:
        r8 = 0;
        goto L39
    L65:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        Object r21 = Result.constructor-impl(com.larus.office.base.utils.e.e(r13));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r21) == false) goto L20;
        r21 = null;
    L20:
        r5 = (Pair) r21;
    L15:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L9:
        if (StringsKt.startsWith$default(r4, "image/", false, 2, null) != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private static Cursor com_larus_doc_sdk_impl_v2_utils_DocSdkFilePickerRouter_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }

    public static /* synthetic */ ew4.l buildCommonFileBean$default(DocSdkFilePickerRouter r1, Context r2, Uri r3, AlbumSelectItem r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.buildCommonFileBean(r2, r3, r4, r5);
    }
}
