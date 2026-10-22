package com.obric.memorydata.memory.bridge;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.google.gson.Gson;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.aikernelcore.ScriptModelResult;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.dc.PageContextData;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.dc.d;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.memory.llm.h;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.memoryentity.c;
import com.obric.memorydata.memory.provider.b;
import com.obric.memorydata.memory.t;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.util.f;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.q;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0000H\u0007J*\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0007H\u0016J2\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#H\u0002J\u0017\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010'J)\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u0005H\u0016J*\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007H\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u00102\u001a\u00020\u0005H\u0002J\u001a\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020CH\u0002J,\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J*\u0010H\u001a\u0004\u0018\u00010\u00052\u0006\u0010B\u001a\u00020C2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007H\u0002J\u001a\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u001a\u0010J\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J,\u0010K\u001a\u0002HL\"\u0004\b\u0000\u0010L*\u00020$2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002HL0NH\u0082\b¢\u0006\u0002\u0010OJ\u0014\u0010P\u001a\u00020\u0015*\u00020E2\u0006\u0010Q\u001a\u00020EH\u0002J\u0018\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\f\u0010T\u001a\u00020\u0015*\u00020\u0005H\u0002J\f\u0010U\u001a\u00020\u0015*\u00020\u0005H\u0002J\f\u0010V\u001a\u00020\u0015*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/memorydata/memory/bridge/MemoryBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IMemoryBuildBridgeAPI;", "<init>", "()V", "TAG", "", "IMAGE_MAX_SIZE", "", "IMAGE_DOWNLOAD_CONNECT_TIMEOUT_MS", "IMAGE_DOWNLOAD_READ_TIMEOUT_MS", "IMAGE_DOWNLOAD_MAX_BYTES", "", "PAGE_CONTEXT_AWAIT_GRACE_MS", "PAGE_CONTEXT_STATE_SKIPPED", "PAGE_CONTEXT_STATE_ERROR", "getInst", "executeMemoryBuild", "modelName", "requestBody", "imageId", "useCloud", "", "getImageBase64", "unbindImage", "", "bindImage", "fileEntityJson", "maxBitmapKB", "(Ljava/lang/String;I)Ljava/lang/Long;", "downloadImageToDir", "imageUrl", "path", "timeoutMs", "downloadImageToDirInternal", "connectionRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/net/HttpURLConnection;", "indexMemoryEntity", "memoryJson", "(Ljava/lang/String;)Ljava/lang/Long;", "indexMemoryEntityWithCalendars", "entityType", "entityUUID", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Long;", "getEnableExtractPackageName", "", "getCalendarFromMemoryEnabled", "searchMemory", "quResult", "takeScreenshot", ObricMemoryConstants.KEY_PACKAGE_NAME, "resizeFactor", "", "compressQuality", "capturePageContext", "showCalendar", "entityId", "resolvePageContextComponent", "Landroid/content/ComponentName;", "buildPageContextResponse", "result", "Lcom/obric/memorydata/dc/PageContextResult;", "sourcePackageName", "state", "message", "bitmapToBase64", "bitmap", "Landroid/graphics/Bitmap;", "buildImageFile", "Ljava/io/File;", "filesDir", "contentType", "saveScreenshotToPath", "buildScreenshotFile", "resolveImageExtension", "useAndDisconnect", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/net/HttpURLConnection;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isInDir", "parent", "isDownloadTimedOut", "startTime", "hasImageExtension", "hasJpegExtension", "isImageExtension", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBridgeImpl implements IMemoryBuildBridgeAPI {
    private static final int IMAGE_DOWNLOAD_CONNECT_TIMEOUT_MS = 10000;
    private static final long IMAGE_DOWNLOAD_MAX_BYTES = 20971520;
    private static final int IMAGE_DOWNLOAD_READ_TIMEOUT_MS = 30000;
    private static final int IMAGE_MAX_SIZE = 1280;
    public static final MemoryBridgeImpl INSTANCE = null;
    private static final long PAGE_CONTEXT_AWAIT_GRACE_MS = 500;
    private static final String PAGE_CONTEXT_STATE_ERROR = "ERROR";
    private static final String PAGE_CONTEXT_STATE_SKIPPED = "SKIPPED";
    private static final String TAG = "MemoryBridgeImpl";

    /* JADX INFO: renamed from: com.obric.memorydata.memory.bridge.MemoryBridgeImpl$executeMemoryBuild$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.bridge.MemoryBridgeImpl$executeMemoryBuild$1", f = "MemoryBridgeImpl.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
        final /* synthetic */ long $imageId;
        final /* synthetic */ String $modelName;
        final /* synthetic */ String $requestBody;
        final /* synthetic */ boolean $useCloud;
        int label;

        AnonymousClass1(String r3, long r4, String r6, boolean r7, Continuation<? super AnonymousClass1> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$requestBody = r3;
            this.$imageId = r4;
            this.$modelName = r6;
            this.$useCloud = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$requestBody, this.$imageId, this.$modelName, this.$useCloud, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super String> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r22);
            Object r0 = r22;
        L37:
            ScriptModelResult r3 = (ScriptModelResult) ZeusTransformUtils.preCheckCast(r0, ScriptModelResult.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L40;
            return null;
        L40:
            return u.a(r3);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().j().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            JSONObject r6 = new JSONObject(this.$requestBody);
            r6.put("uxp", r4);
            if (this.$imageId < 0) goto L34;
            Bitmap r5 = t.f10513a.a(this.$imageId);
            if (r5 == null) goto L34;
            RunLog.INSTANCE.debug(MemoryBridgeImpl.TAG, "replace imageId to base64");
            String r7 = MemoryBridgeImpl.access$bitmapToBase64(MemoryBridgeImpl.INSTANCE, r5);
            JSONObject r8 = r6.optJSONObject("context_data");
            if (r8 == null) goto L15;
            Integer r9 = Boxing.boxInt(r8.optInt("data_type", -1));
        L17:
            if (r9 == null) goto L25;
            if (r9.intValue() != (-1)) goto L25;
            JSONObject r10 = r8.optJSONObject("screen_data");
            if (r10 == null) goto L34;
        L23:
            r10.put("base64_encoded_image", r7);
        L25:
            if (r9 == null) goto L34;
            if (r9.intValue() != 3) goto L34;
            JSONArray r11 = r8.optJSONArray("first_party_app_data");
            if (r11 == null) goto L34;
            r10 = r11.getJSONObject(0);
            if (r10 == null) goto L34;
        L15:
            r9 = null;
        L34:
            com.obric.memorydata.aikernelcore.a r12 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            String r13 = this.$modelName;
            String r14 = r6.toString();
            Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
            boolean r15 = this.$useCloud;
            String r17 = AppContext.INSTANCE.getPackageName();
            Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r0 = com.obric.memorydata.aikernelcore.a.b(r12, r13, r14, r15, 0, r17, r18, 8, null);
            if (r0 != r1) goto L37;
            return r1;
        }
    }

    static {
        INSTANCE = new MemoryBridgeImpl();
    }

    private MemoryBridgeImpl() {
    }

    public static final /* synthetic */ String access$bitmapToBase64(MemoryBridgeImpl r0, Bitmap r1) {
        return r0.bitmapToBase64(r1);
    }

    private final String bitmapToBase64(Bitmap r6) {
        int r5 = r6.getWidth();
        int r0 = r6.getHeight();
        if (r5 > IMAGE_MAX_SIZE) goto L7;
        if (r0 > IMAGE_MAX_SIZE) goto L7;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L13;
        return x.f13267a.a(r6, 60);
    L13:
        if (r5 <= r0) goto L15;
        float r4 = r5;
    L16:
        float r3 = 1280.0f / r4;
        Bitmap r7 = Bitmap.createScaledBitmap(r6, (int) (r5 * r3), (int) (r0 * r3), true);
        Intrinsics.checkNotNullExpressionValue(r7, "createScaledBitmap(...)");
        return x.f13267a.a(r7, 60);
    L15:
        r4 = r0;
    L7:
        r2 = true;
        goto L9
    }

    private final File buildImageFile(File r4, String r5, String r6, String r7) {
        String r0 = new File(r4, r5).getName();
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        return null;
    L9:
        if (hasImageExtension(r0) == true) goto L13;
        r5 = r5 + resolveImageExtension(r6, r7);
    L13:
        return new File(r4, r5).getCanonicalFile();
    }

    private final String buildPageContextResponse(PageContextResult r3, String r4) {
        if (r3 == null) goto L4;
        JSONObject r2 = new JSONObject().put("state", r3.getState().name());
        d r5 = h.f10289a.a(r3, r4);
        if (r5 == null) goto L8;
        r2.put("sourceLink", r5.a());
        r2.put("sourceLinkType", r5.b());
    L8:
        PageContextData r6 = r3.getData();
        if (r6 == null) goto L11;
        r2.put("data", new JSONObject().put(OaidModel.KEY_ID, r6.getId()).put(MemorySourceLinkType.DEEPLINK, r6.getDeeplink()).put("url", r6.getUrl()).put("title", r6.getTitle()).put(Params.CONTENT, r6.getContent()));
    L11:
        String r7 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    L4:
        return buildPageContextResponse(PAGE_CONTEXT_STATE_SKIPPED, "capture not started");
    }

    private final String buildPageContextResponse(String r2, String r3) {
        String r1 = new JSONObject().put("state", r2).put("message", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    private final File buildScreenshotFile(File r4, String r5) {
        String r0 = new File(r4, r5).getName();
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        return null;
    L9:
        if (hasJpegExtension(r0) == true) goto L13;
        r5 = r5 + ".jpeg";
    L13:
        return new File(r4, r5).getCanonicalFile();
    }

    private static final String downloadImageToDir$lambda$1(String r1, String r2, int r3, AtomicReference r4) {
        return INSTANCE.downloadImageToDirInternal(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, java.lang.String, java.lang.Throwable] */
    private final String downloadImageToDirInternal(String r21, String r22, int r23, AtomicReference<HttpURLConnection> r24) {
        ?? r4 = 0;
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L116 Exception -> L118
        URL r7 = new URL(r21);     // Catch: Throwable -> L116 Exception -> L118
        if (Intrinsics.areEqual(r7.getProtocol(), "http") == false) goto L6;
    L10:
        URLConnection r8 = r7.openConnection();     // Catch: Throwable -> L116 Exception -> L118
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Throwable -> L116 Exception -> L118
        HttpURLConnection r9 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r8, HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116 Exception -> L118
        r9.setConnectTimeout(Math.min(10000, r23));     // Catch: Throwable -> L116 Exception -> L118
        r9.setReadTimeout(Math.min(30000, r23));     // Catch: Throwable -> L116 Exception -> L118
        boolean r10 = true;
        r9.setInstanceFollowRedirects(true);     // Catch: Throwable -> L116 Exception -> L118
        r24.set(r9);     // Catch: Throwable -> L116 Exception -> L118
        int r11 = r9.getResponseCode();     // Catch: Throwable -> L113
        MemoryBridgeImpl r12 = INSTANCE;     // Catch: Throwable -> L113
        if (r12.isDownloadTimedOut(r5, r23) == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir timeout", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L18:
        if (200 <= r11) goto L20;
    L22:
        r10 = false;
    L23:
        if (r10 == true) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir http failed, code=" + r11, null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L29:
        if (r9.getContentLengthLong() <= IMAGE_DOWNLOAD_MAX_BYTES) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir content too large", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L34:
        File r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getCanonicalFile();     // Catch: Throwable -> L113
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L113
        File r0 = r12.buildImageFile(r13, r22, r21, r9.getContentType());     // Catch: Throwable -> L113
        if (r0 != null) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir path unavailable", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L41:
        if (r12.isInDir(r0, r13) == true) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir path unavailable", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L46:
        File r14 = r0.getParentFile();     // Catch: Throwable -> L113
        if (r14 == null) goto L51;
        r13 = r14;
    L51:
        if (r13.exists() == true) goto L59;
        if (r13.mkdirs() == true) goto L59;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir mkdir failed", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L59:
        if (r13.isDirectory() == true) goto L61;
    L109:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir dir unavailable", null, 4, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Exception -> L118 Throwable -> L122
        r24.set(null);
        return null;
    L61:
        if (r13.canWrite() == false) goto L109;
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r9.getInputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L113
        InputStream r16 = (InputStream) ZeusTransformUtils.preCheckCast(r15, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r0), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        FileOutputStream r18 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r17, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        byte[] r19 = new byte[8192];     // Catch: Throwable -> L95
        long r110 = 0;
    L67:
        if (INSTANCE.isDownloadTimedOut(r5, r23) == true) goto L68;
        int r111 = r16.read(r19);     // Catch: Throwable -> L95
        if (r111 < 0) goto L76;
        long r112 = r5;
        r110 = r110 + ((long) r111);
        if (r110 > IMAGE_DOWNLOAD_MAX_BYTES) goto L83;
        r18.write(r19, 0, r111);     // Catch: Throwable -> L95
        r5 = r112;
        r4 = 0;
        goto L67
    L83:
        r18.close();     // Catch: Throwable -> L95
        r0.delete();     // Catch: Throwable -> L95
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir stream too large", null, 4, null);     // Catch: Throwable -> L95
        Object r1 = null;
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L102
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L90 Exception -> L118
        r24.set(null);
        return null;
    L90:
        th = th;
    L124:
        r24.set(r1);
        throw th;
    L76:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L95
        CloseableKt.closeFinally(r17, r4);     // Catch: Throwable -> L102
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L102
        CloseableKt.closeFinally(r15, r4);     // Catch: Throwable -> L113
        String r6 = r0.getAbsolutePath();     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(r4);
        return r6;
    L68:
        r18.close();     // Catch: Throwable -> L95
        r0.delete();     // Catch: Throwable -> L95
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir timeout", null, 4, null);     // Catch: Throwable -> L95
        CloseableKt.closeFinally(r17, r4);     // Catch: Throwable -> L102
        CloseableKt.closeFinally(r15, r4);     // Catch: Throwable -> L113
        r9.disconnect();     // Catch: Throwable -> L116 Exception -> L118
        r24.set(r4);
        return r4;
    L95:
        th = move-exception;
        throw th;     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L102
        throw th;     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        throw th;     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L113
        throw th;     // Catch: Throwable -> L113
    L20:
        if (r11 >= 300) goto L22;
    L113:
        th = move-exception;
        r9.disconnect();     // Catch: Exception -> L118 Throwable -> L122
        throw th;     // Catch: Exception -> L118 Throwable -> L122
    L6:
        if (Intrinsics.areEqual(r7.getProtocol(), LocationInfoConst.HTTPS) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir unsupported protocol", null, 4, null);     // Catch: Throwable -> L116 Exception -> L118
        r24.set(null);
        return null;
    L122:
        th = th;
        r1 = null;
    L118:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir error: " + e.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L122
        r24.set(null);
        return null;
    L116:
        th = th;
        r1 = null;
        goto L124
    }

    @JvmStatic
    public static final MemoryBridgeImpl getInst() {
        return INSTANCE;
    }

    private final boolean hasImageExtension(String r3) {
        String r4 = StringsKt.substringAfterLast(r3, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        return isImageExtension(r4);
    }

    private final boolean hasJpegExtension(String r3) {
        Set r2 = SetsKt.setOf(new String[]{"jpg", "jpeg"});
        String r4 = StringsKt.substringAfterLast(r3, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        return r2.contains(r4);
    }

    private final boolean isDownloadTimedOut(long r3, int r5) {
        if ((SystemClock.elapsedRealtime() - r3) <= r5) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isImageExtension(String r9) {
        return SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "webp", "gif", "bmp", "heic", "heif"}).contains(r9);
    }

    private final boolean isInDir(File r3, File r4) {
        if (Intrinsics.areEqual(r3.getPath(), r4.getPath()) == true) goto L6;
        String r2 = r3.getPath();
        Intrinsics.checkNotNullExpressionValue(r2, "getPath(...)");
        if (StringsKt.startsWith$default(r2, r4.getPath() + File.separator, false, 2, null) == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ String lambda$oZ2kuUrsEfcJ0yTmpbbFjIs5Hkc(String r0, String r1, int r2, AtomicReference r3) {
        return downloadImageToDir$lambda$1(r0, r1, r2, r3);
    }

    private final String resolveImageExtension(String r5, String r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        MemoryBridgeImpl r4 = (MemoryBridgeImpl) ZeusTransformUtils.preCheckCast(this, MemoryBridgeImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(new URL(r5).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r7) == false) goto L10;
        r7 = "";
    L10:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8);
        String r9 = StringsKt.substringAfterLast(r8, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "toLowerCase(...)");
        String r3 = null;
        if (INSTANCE.isImageExtension(r9) == true) goto L14;
        r9 = null;
    L14:
        if (r9 != null) goto L16;
        if (r6 == null) goto L24;
        String r10 = StringsKt.substringBefore$default(r6, ';', null, 2, null);
        if (r10 == null) goto L24;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r11 == null) goto L24;
        r3 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
    L24:
        if (r3 != null) goto L26;
        return ".jpg";
    L26:
        switch(r3.hashCode()) {
            case -1487464693: goto L50;
            case -1487464690: goto L46;
            case -1487394660: goto L44;
            case -1487018032: goto L41;
            case -879272239: goto L37;
            case -879267568: goto L33;
            case -879258763: goto L29;
            default: goto L63;
        };
    L44:
        r3.equals("image/jpeg");
        return ".jpg";
    L63:
        return ".jpg";
    L29:
        if (r3.equals("image/png") == false) goto L64;
        return ".png";
    L64:
        return ".jpg";
    L33:
        if (r3.equals("image/gif") == false) goto L65;
        return ".gif";
    L65:
        return ".jpg";
    L37:
        if (r3.equals("image/bmp") == false) goto L66;
        return ".bmp";
    L66:
        return ".jpg";
    L41:
        if (r3.equals("image/webp") == false) goto L67;
        return ".webp";
    L67:
        return ".jpg";
    L46:
        if (r3.equals("image/heif") == false) goto L68;
        return ".heif";
    L68:
        return ".jpg";
    L50:
        if (r3.equals("image/heic") == false) goto L69;
        return ".heic";
    L69:
        return ".jpg";
    L16:
        return '.' + r9;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final ComponentName resolvePageContextComponent(String r3) {
        ComponentName r2 = ba.e();
        if (r2 == null) goto L8;
        if (Intrinsics.areEqual(r2.getPackageName(), r3) == false) goto L8;
        return r2;
    L8:
        return null;
    }

    private final String saveScreenshotToPath(Bitmap r9, String r10, float r11, int r12) {
        File r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getCanonicalFile();     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L23
        File r13 = buildScreenshotFile(r2, r10);     // Catch: Exception -> L23
        if (r13 != null) goto L8;
        MemoryBridgeImpl r8 = (MemoryBridgeImpl) ZeusTransformUtils.preCheckCast(this, MemoryBridgeImpl.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot failed, path unavailable", null, 4, null);     // Catch: Exception -> L23
        return null;
    L8:
        if (isInDir(r13, r2) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot failed, path unavailable", null, 4, null);     // Catch: Exception -> L23
        return null;
    L11:
        File r14 = r13.getParentFile();     // Catch: Exception -> L23
        if (r14 == null) goto L16;
        r2 = r14;
    L16:
        if (r2.exists() == false) goto L18;
    L21:
        x r15 = x.f13267a;     // Catch: Exception -> L23
        String r16 = r13.getAbsolutePath();     // Catch: Exception -> L23
        Intrinsics.checkNotNullExpressionValue(r16, "getAbsolutePath(...)");     // Catch: Exception -> L23
        return r15.a(r9, r16, r11, r12);
    L18:
        if (r2.mkdirs() == true) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot failed, mkdir failed", null, 4, null);     // Catch: Exception -> L23
        return null;
    L23:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot failed: " + e.getClass().getSimpleName(), null, 4, null);
        return null;
    }

    private final <T> T useAndDisconnect(HttpURLConnection r2, Function1<? super HttpURLConnection, ? extends T> r3) {
        T r1 = (T) ((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin")).invoke(r2);
        InlineMarker.finallyStart(1);
        r2.disconnect();
        InlineMarker.finallyEnd(1);
        return r1;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.disconnect();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long bindImage(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "fileEntityJson");
        FileEntity r7 = f.c(r8);
        if (r7 != null) goto L7;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r4 = null;
        int r5 = 4;
        Object r6 = null;
        String r2 = TAG;
        String r3 = "bindImage failed, fileEntity is null";
    L5:
        IRunLog.a.a(r1, r2, r3, r4, r5, r6);
        return null;
    L7:
        AssetFileDescriptor r10 = ((UriFileAccessSession) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryBridgeImpl$bindImage$permission$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin")).getFd();
        if (r10 == null) goto L10;
        FileDescriptor r11 = r10.getFileDescriptor();
    L11:
        if (r11 != null) goto L13;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = null;
        r5 = 4;
        r6 = null;
        r2 = TAG;
        r3 = "bindImage failed, permission.fd is null";
        goto L5
    L13:
        Bitmap r12 = x.f13267a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, r9);
        r10.close();
        if (r12 != null) goto L17;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = null;
        r5 = 4;
        r6 = null;
        r2 = TAG;
        r3 = "bindImage failed, bitmap is null";
        goto L5
    L17:
        return Long.valueOf(t.f10513a.a(r12));
    L10:
        r11 = null;
        goto L11
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String capturePageContext(String r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        String r15 = "packageName is empty";
    L6:
        return buildPageContextResponse(PAGE_CONTEXT_STATE_SKIPPED, r15);
    L7:
        ComponentName r0 = resolvePageContextComponent(r14);
        if (r0 != null) goto L10;
        r15 = "current top activity does not match";
        goto L6
    L10:
        Long r16 = Long.valueOf(r13);
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L13;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L18;
        r16 = null;
    L18:
        if (r16 == null) goto L20;
        long r18 = r16.longValue();
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "capturePageContext request, packageName=" + r14 + ", timeoutMs=" + r18, false, 4, null);
        return buildPageContextResponse((PageContextResult) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryBridgeImpl$capturePageContext$result$1(r0, r18, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), PageContextResult.class, "com.obric.memorydata.plugin"), r14);
    L24:
        th = move-exception;
        RunLog.INSTANCE.error(TAG, "capturePageContext failed", th);
        String r19 = th.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r19, "getSimpleName(...)");
        return buildPageContextResponse("ERROR", r19);
    L20:
        r18 = 10000;
        goto L21
    L13:
        r17 = false;
        goto L15
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String downloadImageToDir(final String r10, final String r11, final int r12) {
        Intrinsics.checkNotNullParameter(r10, "imageUrl");
        Intrinsics.checkNotNullParameter(r11, "path");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "downloadImageToDir invalid params", null, 4, null);
        return null;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
        if (r12 <= 0) goto L25;
        final AtomicReference r9 = new AtomicReference();
        ExecutorService r2 = Executors.newSingleThreadExecutor();
        Future r13 = r2.submit(new $$Lambda$MemoryBridgeImpl$oZ2kuUrsEfcJ0yTmpbbFjIs5Hkc(r10, r11, r12, r9));
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get(r12, TimeUnit.MILLISECONDS), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13 TimeoutException -> L17
        r2.shutdownNow();
        return r14;
    L11:
        th = move-exception;
        r2.shutdownNow();
        throw th;
    L17:
        HttpURLConnection r15 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r9.get(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r15 == null) goto L20;
        r15.disconnect();     // Catch: Throwable -> L11
    L20:
        r13.cancel(true);     // Catch: Throwable -> L11
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        String r4 = TAG;
        String r5 = "downloadImageToDir timeout";
    L15:
        IRunLog.a.a(r3, r4, r5, null, 4, null);     // Catch: Throwable -> L11
        r2.shutdownNow();
        return null;
    L13:
        e = move-exception;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r4 = TAG;
        r5 = "downloadImageToDir error: " + e.getClass().getSimpleName();     // Catch: Throwable -> L11
        goto L15
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String executeMemoryBuild(String r8, String r9, long r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "modelName");
        Intrinsics.checkNotNullParameter(r9, "requestBody");
        return (String) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, r10, r8, r12, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public boolean getCalendarFromMemoryEnabled() {
        return b.f10359a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Set<String> getEnableExtractPackageName() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return SetsKt.emptySet();
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String getImageBase64(long r1) {
        Bitmap r0 = t.f10513a.a(r1);
        if (r0 == null) goto L6;
        String r2 = INSTANCE.bitmapToBase64(r0);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long indexMemoryEntity(String r33) {
        Intrinsics.checkNotNullParameter(r33, "memoryJson");
        JSONObject r3 = new JSONObject(r33);
        String r1 = r3.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        String r2 = r3.optString("appName");
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        MemoryEntity r0 = c.a(c.f10314a, r3, new com.obric.memorydata.memory.memoryentity.f(6, r1, r2, null, null, null, null, null, null, false, null, null, null, null, null, null, null, false, null, null, null, null, 0.0f, 0, 16777088, null), null, 0, 12, null);
        Long r4 = null;
        if (r0 == null) goto L12;
        MemoryEntity r13 = MemoryEntityManager.INSTANCE.index(r0);
        String r10 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        IslandRouter r9 = IslandRouter.f10185a;
        if (r13 != null) goto L7;
        State r5 = State.SUCCESS_NEW;
    L8:
        IslandRouter.a(r9, r10, r5.ordinal(), r0, r13, false, null, 32, null);
        RawMemoryEntity r6 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r0.getId(), r0.get_packageName())), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        r4 = Long.valueOf(r6.getId());
    L11:
        RunLog r7 = RunLog.INSTANCE;
        String r8 = "indexMemoryEntity dbId: " + r4;
    L13:
        r7.debug(TAG, r8);
        return r4;
    L7:
        r5 = State.SUCCESS_UPDATE;
        goto L8
    L12:
        r7 = RunLog.INSTANCE;
        r8 = "indexMemoryEntity failed";
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long indexMemoryEntityWithCalendars(String r35, int r36, String r37) {
        Intrinsics.checkNotNullParameter(r37, "entityUUID");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexMemoryEntityWithCalendars", false, 4, null);
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        List<PendingMemoryCalendar> r5 = null;
        if (r3 == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexMemoryEntityWithCalendars memoryJson is empty", null, 4, null);
        MemoryEntity r0 = null;
        JSONObject r4 = null;
        String r6 = null;
    L12:
        Long r7 = r6;
    L21:
        if (r0 == null) goto L24;
        if (r6 == null) goto L24;
        List<PendingMemoryCalendar> r1 = com.obric.memorydata.memory.calendar.c.f10086a.a(r0, r6, r4);
    L25:
        if (r1 != null) goto L27;
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index calendarInfo empty", false, 4, null);
    L35:
        return r7;
    L27:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        r5 = r1;
    L29:
        if (r5 == null) goto L34;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L32:
        if (r8.hasNext() == false) goto L35;
        PendingMemoryCalendar r9 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r8.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "index calendarInfo: " + q.f13259a.b(r9.getTitle()) + ", " + r9.getDtstart() + ", " + r9.getDtend(), false, 4, null);
    L24:
        r1 = com.obric.memorydata.memory.calendar.c.f10086a.a(r36, r37, r4);
        goto L25
    L13:
        r4 = new JSONObject(r35);
        String r10 = r4.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        String r11 = r4.optString("appName");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        r0 = c.a(c.f10314a, r4, new com.obric.memorydata.memory.memoryentity.f(6, r10, r11, null, null, null, null, null, null, false, null, null, null, null, null, null, null, false, null, null, null, null, 0.0f, 0, 16777088, null), null, 0, 12, null);
        if (r0 == null) goto L20;
        MemoryEntityManager.INSTANCE.index(r0);
        RawMemoryEntity r12 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r0.getId(), r0.get_packageName())), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L18;
        Long r13 = Long.valueOf(r12.getId());
        r6 = r12.getUuid();
        Long r14 = r13;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexMemoryEntity dbId: " + r14, false, 4, null);
        r7 = r14;
        goto L21
    L18:
        r6 = null;
        r14 = null;
        goto L19
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "indexMemoryEntity failed", false, 4, null);
        r6 = null;
        goto L12
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String searchMemory(String r8) {
        Intrinsics.checkNotNullParameter(r8, "quResult");
        long r0 = System.currentTimeMillis();
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryBridgeImpl$searchMemory$entityList$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r4 = r10.next();
        if (ZeusTransformUtils.instanceOf((AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin"), InfoCommonMemoryEntity.class) == false) goto L4;
        r9.add(r4);
        goto L4
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L19;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r13.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, InfoCommonMemoryEntity.class) == false) goto L14;
        InfoCommonMemoryEntity r6 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r5, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L15:
        if (r6 == null) goto L17;
        InfoCommonEntitySimplify r14 = a.a(r6);
    L18:
        r12.add(r14);
        goto L10
    L17:
        r14 = null;
        goto L18
    L14:
        r6 = null;
        goto L15
    L19:
        String r15 = new Gson().toJson((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug(TAG, "searchMemory cost: " + (System.currentTimeMillis() - r0));
        Intrinsics.checkNotNull(r15);
        return r15;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public boolean showCalendar(String r9) {
        Intrinsics.checkNotNullParameter(r9, "entityId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showCalendar failed, entityId is blank", null, 4, null);
        return false;
    L25:
        MemoryEntity r8 = com.obric.memorydata.memory.utils.f.a(com.obric.memorydata.memory.utils.f.f11537a, r9, null, 2, null);     // Catch: Exception -> L22
        if (r8 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showCalendar failed, memoryEntity is null", null, 4, null);     // Catch: Exception -> L22
        return false;
    L10:
        String r10 = r8.getUuid();     // Catch: Exception -> L22
        if (r10 == null) goto L13;
        List<PendingMemoryCalendar> r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().queryByMemoryUUIDSync(r10);     // Catch: Exception -> L22
    L14:
        if (r11 != null) goto L17;
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L22
    L17:
        if (r11.isEmpty() == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showCalendar skipped, calendars is empty", null, 4, null);     // Catch: Exception -> L22
        return false;
    L20:
        IslandRouter.f10185a.a(r8, null, r11);     // Catch: Exception -> L22
        return true;
    L13:
        r11 = null;
    L22:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showCalendar failed: " + e.getClass().getSimpleName(), null, 4, null);
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String takeScreenshot(String r7) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot packageName: " + r7, false, 4, null);
        IslandRouter.f10185a.b();
        return null;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String takeScreenshot(String r10, String r11, float r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "path");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "takeScreenshot packageName: " + r10, false, 4, null);
        Float r14 = Float.valueOf(r12);
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r0 > 0.0f) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        r14 = null;
    L12:
        if (r14 == null) goto L26;
        float r15 = r14.floatValue();
        int r16 = RangesKt.coerceIn(r13, 0, 100);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
    L25:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r5 = null;
        int r6 = 4;
        Object r7 = null;
        String r3 = TAG;
        String r4 = "takeScreenshot failed, invalid params";
    L21:
        IRunLog.a.a(r2, r3, r4, r5, r6, r7);
        return null;
    L16:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
        Bitmap r17 = com.obric.memorydata.utils.e.c.a(com.obric.memorydata.utils.e.c.f13216a, r10, null, 2, null);
        if (r17 != null) goto L24;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "takeScreenshot failed, screenshot is null";
        goto L21
    L24:
        return saveScreenshotToPath(r17, r11, r15, r16);
    L26:
        MemoryBridgeImpl r9 = (MemoryBridgeImpl) ZeusTransformUtils.preCheckCast(this, MemoryBridgeImpl.class, "com.obric.memorydata.plugin");
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "takeScreenshot failed, invalid resizeFactor";
        goto L21
    L5:
        if (r0 > 1.0f) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public void unbindImage(long r3) {
        RunLog.INSTANCE.debug(TAG, "unbindImage imageId: " + r3);
        t.f10513a.b(r3);
    }
}
