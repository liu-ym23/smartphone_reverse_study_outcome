package com.larus.drive.sdk.impl.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.GetVideoModelResults;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ObjTokenGetUrlHelper {
    public static final ObjTokenGetUrlHelper a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FlowDriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L29:
            r0[FlowDriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[DriveFileType.values().length];
            r1[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L31:
            r1[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[DriveFileType.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    static {
        a = new ObjTokenGetUrlHelper();
    }

    public ObjTokenGetUrlHelper() {
    }

    public final Object c(String r6, Continuation<? super String> r7) {
        if ((r7 instanceof ObjTokenGetUrlHelper$requireAudioUrl$1) == false) goto L7;
        ObjTokenGetUrlHelper$requireAudioUrl$1 r0 = (ObjTokenGetUrlHelper$requireAudioUrl$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.a) == false) goto L21;
        return null;
    L21:
        if ((r9 instanceof dm9.a.b) == false) goto L33;
        GetVideoModelResults r10 = (GetVideoModelResults) r9.a.getData();
        if (r10 == null) goto L34;
        List r11 = r10.getResults();
        if (r11 == null) goto L35;
        GetVideoModelResultItem r12 = (GetVideoModelResultItem) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L36;
        VideoUrlResult r13 = r12.getVideoUrlResult();
        if (r13 != null) goto L31;
        return null;
    L31:
        return r13.getVideoUrl();
    L36:
        return null;
    L35:
        return null;
    L34:
        return null;
    L33:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ResourceApi.a r14 = ResourceApi.a;
        ObjTokenGetUrlHelper$requireAudioUrl$2 r4 = new ObjTokenGetUrlHelper$requireAudioUrl$2(r6, null);
        r0.label = 1;
        r14.getClass();
        r8 = ResourceApi.a.a("/alice/resource/get_video_model", r4, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObjTokenGetUrlHelper$requireAudioUrl$1(this, r7);
        goto L8
    }

    public static Object d(List r12, UploadDataType r13, Continuation r14) {
        JSONObject r3 = new JSONObject();
        r3.put("uris", new JSONArray(r12));
        r3.put("type", r13.getType());
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Drive", FileUrlRespData.class, "/alice/message/get_file_url", r3, null, null, false, null, null, null, r14, 1008);
    }

    public final Object b(String r6, FlowDriveFileType r7, Continuation<? super String> r8) {
        if ((r8 instanceof ObjTokenGetUrlHelper$getUrlByTokenSuspend$1) == false) goto L7;
        ObjTokenGetUrlHelper$getUrlByTokenSuspend$1 r0 = (ObjTokenGetUrlHelper$getUrlByTokenSuspend$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L31:
        FileUrlRespData r10 = (FileUrlRespData) ((com.larus.network.http.a) r9).b;
        if (r10 == null) goto L40;
        List r11 = r10.getFileUrlList();
        if (r11 == null) goto L40;
        FileUrlData r12 = (FileUrlData) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L40;
        String r13 = r12.getMainUrl();
        if (r13 == null) goto L43;
        return r13;
    L43:
        return r12.getBackUrl();
    L40:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L25:
        return r9;
    L16:
        ResultKt.throwOnFailure(r9);
        int r14 = a.a[r7.ordinal()];
        if (r14 == 1) goto L27;
        if (r14 != 2) goto L20;
        UploadDataType r15 = UploadDataType.VIDEO;
    L28:
        List r16 = CollectionsKt.listOf(r6);
        r0.label = 2;
        r9 = d(r16, r15, r0);
        if (r9 != r2) goto L31;
        return r2;
    L20:
        if (r14 == 3) goto L22;
        r15 = UploadDataType.FILE;
        goto L28
    L22:
        r0.label = 1;
        r9 = c(r6, r0);
        if (r9 != r2) goto L25;
        return r2;
    L27:
        r15 = UploadDataType.IMAGE;
    L7:
        r0 = new ObjTokenGetUrlHelper$getUrlByTokenSuspend$1(this, r8);
        goto L8
    }

    public static void a(String r12, FlowDriveFileType r13, LifecycleCoroutineScope r14, Function1 r15, Function1 r16) {
        Intrinsics.checkNotNullParameter(r12, "objTokenString");
        Intrinsics.checkNotNullParameter(r13, "fileType");
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "onSuccess");
        if (r13 != FlowDriveFileType.NON_FILE) goto L6;
        FLogger.a.i("ObjTokenGetUrlHelper", "[getUrlByToken] This is not a file, stop get url");
        return;
    L6:
        BuildersKt.launch$default(r14, Dispatchers.getIO(), null, new ObjTokenGetUrlHelper$getUrlByToken$1(r13, r12, r14, r15, r16, null), 2, null);
    }
}
