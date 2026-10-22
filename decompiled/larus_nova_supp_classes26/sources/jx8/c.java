package jx8;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.platform.model.camera.ICameraEventExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.camera.api.params.InputParam] */
    public static InputParam a(hx8.a r6, ICameraEventExt r7) {
        Intrinsics.checkNotNullParameter(r6, "cameraConfig");
        List<Pair<String, String>> r0 = r6.c;
        if (r0 == null) goto L8;
        List<Pair<String, String>> r1 = r0;
        ?? r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        Pair r4 = (Pair) r3.next();
        r2.add(new CaptureMode((String) r4.getFirst(), (String) r4.getSecond()));
    L9:
        if (r2 != 0) goto L11;
        r2 = CollectionsKt.emptyList();
    L11:
        InputParamExtra r5 = new InputParamExtra();
        r5.putAll(r6.e);
        String r8 = r6.v;
        if (r8 == null) goto L14;
        r5.put("SUGGESTION_PREFIX", r8);
    L14:
        r5.put("SHOW_BOTTOM_ALBUM", String.valueOf(r6.w));
        String r9 = r6.a;
        Intrinsics.checkNotNullParameter(r9, "scene");
        ?? r10 = new InputParam(null);
        r10.setScene(r9);
        String r11 = r6.b;
        Intrinsics.checkNotNullParameter(r11, "captureMode");
        ?? r12 = r2;
        if (r2 != 0) goto L17;
        r12 = CollectionsKt.emptyList();
    L17:
        r10.setCaptureModeList(r12);
        r10.setCaptureMode(r11);
        Intrinsics.checkNotNullParameter("FLASH_MODE_AUTO", "flashMode");
        r10.setFlashMode("FLASH_MODE_AUTO");
        r10.setFrontCamera(false);
        Intrinsics.checkNotNullParameter("TARGET_SHOW_GET", "target");
        r10.setTarget("TARGET_SHOW_GET");
        r10.setEventExt(r7);
        r10.setEnableCaptureDetectModeList(r6.f);
        r10.setCameraNameUrl(r6.g);
        r10.setCameraName(r6.h);
        r10.setTipsShowOrder(r6.i);
        r10.setTips(r6.j);
        r10.setSupportCrop(r6.l);
        r10.setSupportMark(r6.k);
        r10.setSupportMultiImages(r6.m);
        r10.setBotId(r6.n);
        r10.setEnableFocusFrame(r6.o);
        r10.setInputStyle(r6.p);
        r10.setSupportRecord(r6.q);
        r10.setAlbumLandingTabIndex(r6.r);
        r10.setAddedAttachmentCount(r6.s);
        r10.setSupportAlbumMultiTake(r6.t);
        r10.setAlbumMultiTakeMaxCount(r6.u);
        r10.setAlbumSupportOriginalImage(r6.x);
        r10.setEnableCaptureAlbum(r6.z);
        r10.setEnableOriginalImageDeferredEdit(r6.y);
        String r13 = r6.A;
        List<String> r14 = r6.B;
        Intrinsics.checkNotNullParameter(r13, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r14, "attachmentUris");
        r10.setAlbumInputText(r13);
        r10.setAlbumAttachmentUris(r14);
        r10.setResultRoute(r6.C);
        r10.setInitialOutputContext(r6.D);
        r10.setExtra(r5);
        return r10;
    L8:
        r2 = 0;
        goto L9
    }
}
