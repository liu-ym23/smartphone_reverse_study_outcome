package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.chat.gallery.api.PreviewSelectionLimit;
import com.larus.chat.gallery.impl.preview.OriginalImagePreloader;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkAction implements o {
    public static final /* synthetic */ int h = 0;
    public final PreviewCameraParamProvider a;
    public final com.larus.chat.gallery.impl.preview.input.e0 b;
    public final com.larus.chat.gallery.api.q c;
    public final AttachmentEditType d;
    public final ToolbarButtonType e;
    public final Function1<xy8.d, Boolean> f;
    public boolean g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[PreviewSelectionLimit.MediaScope.values().length];
            r1[PreviewSelectionLimit.MediaScope.IMAGE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    static {
    }

    public static String f(xy8.d r5) {
        xy8.f r0 = r5.l;
        boolean r1 = false;
        if (r0 == null) goto L21;
        List<UplinkFileEntity> r2 = r0.f;
        if (r2 == null) goto L21;
        UplinkFileEntity r3 = (UplinkFileEntity) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L21;
        Image r4 = l1.c(r3);
        if (r4 == null) goto L21;
        String r6 = r4.key;
        if (r6 == null) goto L21;
        if (r6.length() <= 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L21;
        return r6;
    L15:
        r7 = false;
    L21:
        UserCreation r8 = r5.n;
        if (r8 != null) goto L24;
        return null;
    L24:
        int r9 = r8.b;
        if (r9 != 3) goto L27;
        UserCreationContent r10 = r8.e;
        if (r10 == null) goto L43;
        UserCreationUserAvatar r11 = r10.c;
        if (r11 == null) goto L43;
        ImageInfo r12 = r11.a;
    L44:
        if (r12 == null) goto L53;
        String r13 = r12.e;
        if (r13 != null) goto L48;
        return null;
    L48:
        if (r13.length() <= 0) goto L50;
        r1 = true;
    L50:
        if (r1 == true) goto L52;
        return null;
    L52:
        return r13;
    L53:
        return null;
    L43:
        r12 = null;
        goto L44
    L27:
        if (r9 == 4) goto L33;
        UserCreationContent r14 = r8.e;
        if (r14 == null) goto L43;
        UserCreationImage r15 = r14.a;
        if (r15 == null) goto L43;
        r12 = r15.a;
        goto L44
    L33:
        UserCreationContent r16 = r8.e;
        if (r16 == null) goto L43;
        AiBeautifyUserContent r17 = r16.d;
        if (r17 == null) goto L43;
        r12 = r17.a;
        goto L44
    }

    public static void d(l0 r8, xy8.d r9) {
        if (r8.i == false) goto L5;
        String r10 = "more_panel_click";
    L6:
        xy8.e r0 = r9.m;
        String r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.e;
        if (r2 == null) goto L10;
    L13:
        if (r0 == null) goto L18;
        String r3 = r0.c;
        if (r3 == null) goto L18;
        r1 = r3;
    L21:
        int r4 = r9.q;
        if (r9.a != SourceType.USER_SEND) goto L24;
        String r5 = "user";
    L26:
        if (b.a[r9.e.ordinal()] != 2) goto L28;
        String r6 = "video_detail";
    L29:
        JSONObject r7 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r11 = r9.f.entrySet().iterator();
    L31:
        if (r11.hasNext() == false) goto L33;
        Map.Entry<String, Object> r12 = r11.next();
        r7.put(r12.getKey(), r12.getValue());
        goto L31
    L33:
        boolean r13 = true;
        if (r2 != null) goto L36;
    L39:
        boolean r14 = true;
    L40:
        if (r14 == true) goto L42;
        r7.put("creation_task_id", r2);
    L42:
        if (r1 != null) goto L44;
    L47:
        if (r13 == true) goto L49;
        r7.put(MusicAppletPage.KEY_MESSAGE_ID, r1);
    L49:
        r7.put("position", r4);
        r7.put("user_type", r5);
        r7.put("click_from", r10);
        r7.put("current_page", r6);
        com.larus.platform.service.o.a.reportEvent("click_mark_button", r7);
        return;
    L44:
        if (r1.length() == 0) goto L47;
        r13 = false;
        goto L47
    L36:
        if (r2.length() == 0) goto L39;
        r14 = false;
        goto L40
    L28:
        r6 = "picture_detail";
        goto L29
    L24:
        r5 = "bot";
    L18:
        xy8.f r15 = r9.l;
        if (r15 == null) goto L21;
        r1 = r15.a;
    L10:
        if (r0 == null) goto L12;
        r2 = r0.a;
        goto L13
    L12:
        r2 = null;
        goto L13
    L5:
        r10 = "detail_click";
        goto L6
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r26, Continuation<? super Unit> r27) {
        l0 r2 = r26;
        String r4 = "execute: fetchBitmap result=";
        if ((r27 instanceof MarkAction$execute$1) == false) goto L7;
        MarkAction$execute$1 r5 = (MarkAction$execute$1) r27;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r0 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L29;
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L18;
        if (r8 != 3) goto L17;
        String r3 = (String) r5.L$7;
        IFlowCamera r9 = (IFlowCamera) r5.L$6;
        FragmentActivity r10 = (FragmentActivity) r5.L$5;
        String r11 = (String) r5.L$4;
        String r12 = (String) r5.L$3;
        xy8.d r13 = (xy8.d) r5.L$2;
        Job r15 = (Job) r5.L$1;
        l0 r14 = (l0) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L345
        r4 = "execute: fetchBitmap result=";
    L195:
        Bitmap r1 = (Bitmap) r0;     // Catch: Throwable -> L345
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L345
        StringBuilder r17 = new StringBuilder(r4);     // Catch: Throwable -> L345
        if (r1 == null) goto L198;
        boolean r18 = true;
    L199:
        r17.append(r18);     // Catch: Throwable -> L345
        r17.append(", size=");     // Catch: Throwable -> L345
        if (r1 == null) goto L202;
        Integer r19 = Boxing.boxInt(r1.getWidth());     // Catch: Throwable -> L345
    L203:
        r17.append(r19);     // Catch: Throwable -> L345
        r17.append('x');     // Catch: Throwable -> L345
        if (r1 == null) goto L206;
        Integer r110 = Boxing.boxInt(r1.getHeight());     // Catch: Throwable -> L345
    L207:
        r17.append(r110);     // Catch: Throwable -> L345
        r16.i("MarkAction", r17.toString());     // Catch: Throwable -> L345
        if (r1 != null) goto L228;
        if (r11 != null) goto L211;
    L217:
        boolean r20 = false;
    L218:
        if (r20 == false) goto L228;
        t19.s r21 = t19.s.a;     // Catch: Throwable -> L345
        OriginalImagePreloader r22 = OriginalImagePreloader.a;     // Catch: Throwable -> L345
        r21.getClass();     // Catch: Throwable -> L345
        t19.s.b(r10, 2131899435, false);     // Catch: Throwable -> L345
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r15 == null) goto L222;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L222:
        PreviewToolbarView r24 = r14.f;
        if (r24 == null) goto L225;
        r24.a(this.e, false);
    L225:
        this.g = false;
        return r23;
    L211:
        if (r11.length() <= 0) goto L213;
        boolean r25 = true;
    L215:
        if (r25 != true) goto L217;
        r20 = true;
        goto L218
    L213:
        r25 = false;
    L228:
        if (b(r10, r13) == true) goto L238;
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r15 == null) goto L232;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L232:
        PreviewToolbarView r29 = r14.f;
        if (r29 == null) goto L235;
        boolean r30 = false;
        r29.a(this.e, false);
    L236:
        this.g = r30;
        return r28;
    L235:
        r30 = false;
        goto L236
    L238:
        PreviewCameraParamProvider r31 = this.a;     // Catch: Throwable -> L345
        if (r13 == null) goto L243;
        r31.getClass();     // Catch: Throwable -> L345
        xy8.b r111 = r13.c;     // Catch: Throwable -> L345
        if (r111 == null) goto L243;
        boolean r112 = Intrinsics.areEqual(r111.e, Boolean.TRUE);     // Catch: Throwable -> L345
    L244:
        r31.i = r112;     // Catch: Throwable -> L345
        PreviewCameraParamProvider r32 = this.a;     // Catch: Throwable -> L345
        AttachmentEditType r113 = this.d;     // Catch: Throwable -> L345
        AttachmentEditType r114 = AttachmentEditType.MARK;     // Catch: Throwable -> L345
        if (r113 != r114) goto L247;
        AttachmentEditType r115 = AttachmentEditType.OTHER;     // Catch: Throwable -> L345
    L248:
        if (r113 != r114) goto L250;
    L253:
        boolean r116 = true;
    L254:
        com.larus.chat.gallery.api.q r33 = this.c;     // Catch: Throwable -> L345
        if (r33 == null) goto L257;
        String r34 = r33.j();     // Catch: Throwable -> L345
    L258:
        InputParam r35 = r32.e(r115, r116, r34);     // Catch: Throwable -> L345
        PreviewCameraParamProvider r36 = this.a;     // Catch: Throwable -> L345
        com.larus.chat.gallery.api.q r117 = this.c;     // Catch: Throwable -> L345
        String r118 = r13.i;     // Catch: Throwable -> L345
        if (r118 != null) goto L261;
        r118 = r13.b;     // Catch: Throwable -> L345
    L261:
        r36.b(r35, r117, r13, SetsKt.setOf(r118));     // Catch: Throwable -> L345
        if (r12 != null) goto L264;
    L267:
        boolean r37 = true;
    L268:
        if (r37 == true) goto L273;
        InputParamExtra r38 = r35.getExtra();     // Catch: Throwable -> L345
        if (r38 != null) goto L272;
        r38 = new InputParamExtra();     // Catch: Throwable -> L345
        r35.setExtra(r38);     // Catch: Throwable -> L345
    L272:
        r38.put(InputParamExtra.KEY_RAW_IMAGE_URI, r12);     // Catch: Throwable -> L345
        r35.setEnableOriginalImageDeferredEdit(true);     // Catch: Throwable -> L345
    L273:
        if (r3 != null) goto L275;
    L278:
        boolean r39 = true;
    L279:
        if (r39 == true) goto L284;
        InputParamExtra r40 = r35.getExtra();     // Catch: Throwable -> L345
        if (r40 != null) goto L283;
        r40 = new InputParamExtra();     // Catch: Throwable -> L345
        r35.setExtra(r40);     // Catch: Throwable -> L345
    L283:
        r40.put(InputParamExtra.KEY_DOWNLOAD_WATERMARK_URL, r3);     // Catch: Throwable -> L345
    L284:
        OutputParam r41 = new OutputParam();     // Catch: Throwable -> L345
        r41.setResultType(OutputParam.ResultType.PHOTO);     // Catch: Throwable -> L345
        ImageParam r42 = new ImageParam();     // Catch: Throwable -> L345
        if (r11 != null) goto L287;
        r11 = "";
    L287:
        r42.setPath(r11);     // Catch: Throwable -> L345
        r42.setBitmap(r1);     // Catch: Throwable -> L345
        xy8.b r43 = r13.c;     // Catch: Throwable -> L345
        if (r43 == null) goto L290;
        boolean r44 = Intrinsics.areEqual(r43.e, Boxing.boxBoolean(true));     // Catch: Throwable -> L345
    L291:
        r42.setAiCreation(r44);     // Catch: Throwable -> L345
        r41.setImageParam(r42);     // Catch: Throwable -> L345
        r41.setSelected(true);     // Catch: Throwable -> L345
        r41.setFromAlbum(false);     // Catch: Throwable -> L345
        CameraOutputContext r45 = new CameraOutputContext();     // Catch: Throwable -> L345
        r45.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r41}));     // Catch: Throwable -> L345
        PreviewCameraParamProvider r46 = this.a;     // Catch: Throwable -> L345
        AttachmentEditType r47 = this.d;     // Catch: Throwable -> L345
        r46.getClass();     // Catch: Throwable -> L345
        Intrinsics.checkNotNullParameter(r47, "editType");     // Catch: Throwable -> L345
        r46.m = r47;     // Catch: Throwable -> L345
        Function0<Boolean> r48 = this.a.k;     // Catch: Throwable -> L345
        if (r48 == null) goto L294;
        boolean r49 = ((Boolean) r48.invoke()).booleanValue();     // Catch: Throwable -> L345
    L295:
        if (r49 == true) goto L305;
        this.a.k();     // Catch: Throwable -> L345
        r16.e("MarkAction", "execute: pending result unavailable, abort");     // Catch: Throwable -> L345
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r15 == null) goto L299;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L299:
        PreviewToolbarView r51 = r14.f;
        if (r51 == null) goto L302;
        boolean r52 = false;
        r51.a(this.e, false);
    L303:
        this.g = r52;
        return r50;
    L302:
        r52 = false;
        goto L303
    L305:
        com.larus.chat.gallery.impl.preview.input.e0 r53 = this.b;     // Catch: Throwable -> L345
        if (r53 == null) goto L375;
        r53.c(false);     // Catch: Throwable -> L345
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L345
    L375:
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L314
        if (this.d != r114) goto L311;
        r9.j(r10, r35, r45);     // Catch: Throwable -> L314
        boolean r56 = true;
    L312:
        Object r57 = Result.constructor-impl(Boxing.boxBoolean(r56));     // Catch: Throwable -> L314
    L316:
        Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L345
        if (r58 == null) goto L321;
        FLogger.a.e("MarkAction", "execute: image editor launch failed", r58);     // Catch: Throwable -> L345
        r57 = Boxing.boxBoolean(false);     // Catch: Throwable -> L345
    L321:
        if (((Boolean) r57).booleanValue() == true) goto L337;
        com.larus.chat.gallery.impl.preview.input.e0 r59 = this.b;     // Catch: Throwable -> L345
        if (r59 == null) goto L325;
        r59.c(true);     // Catch: Throwable -> L345
        Unit r60 = Unit.INSTANCE;     // Catch: Throwable -> L345
    L325:
        this.a.k();     // Catch: Throwable -> L345
        Function0<Unit> r61 = this.a.l;     // Catch: Throwable -> L345
        if (r61 == null) goto L328;
        r61.invoke();     // Catch: Throwable -> L345
    L328:
        FLogger.a.e("MarkAction", "execute: image editor was not launched");     // Catch: Throwable -> L345
        Unit r62 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r15 == null) goto L331;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L331:
        PreviewToolbarView r63 = r14.f;
        if (r63 == null) goto L334;
        boolean r64 = false;
        r63.a(this.e, false);
    L335:
        this.g = r64;
        return r62;
    L334:
        r64 = false;
        goto L335
    L337:
        if (r15 == null) goto L339;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
        Unit r65 = Unit.INSTANCE;
    L339:
        PreviewToolbarView r66 = r14.f;
        if (r66 == null) goto L342;
        boolean r67 = false;
        r66.a(this.e, false);
        Unit r68 = Unit.INSTANCE;
    L343:
        this.g = r67;
        return Unit.INSTANCE;
    L342:
        r67 = false;
        goto L343
    L311:
        r56 = r9.n(r10, r35, r45);     // Catch: Throwable -> L314
    L314:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L345
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L345
        goto L316
    L294:
        r49 = true;
        goto L295
    L290:
        r44 = false;
        goto L291
    L275:
        if (r3.length() == 0) goto L278;
        r39 = false;
        goto L279
    L264:
        if (r12.length() == 0) goto L267;
        r37 = false;
        goto L268
    L257:
        r34 = null;
        goto L258
    L250:
        if (((Boolean) this.f.invoke(r13)).booleanValue() == true) goto L253;
        r116 = false;
        goto L254
    L247:
        r115 = r113;
    L243:
        r112 = false;
        goto L244
    L206:
        r110 = null;
        goto L207
    L202:
        r19 = null;
        goto L203
    L198:
        r18 = false;
    L345:
        th = th;
    L349:
        r2 = r14;
    L352:
        if (r15 == null) goto L354;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
        Unit r70 = Unit.INSTANCE;
    L354:
        PreviewToolbarView r71 = r2.f;
        if (r71 == null) goto L357;
        boolean r72 = false;
        r71.a(this.e, false);
        Unit r73 = Unit.INSTANCE;
    L358:
        this.g = r72;
        throw th;
    L357:
        r72 = false;
        goto L358
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r3 = (String) r5.L$7;
        r9 = (IFlowCamera) r5.L$6;
        FragmentActivity r74 = (FragmentActivity) r5.L$5;
        String r75 = (String) r5.L$4;
        String r119 = (String) r5.L$3;
        r13 = (xy8.d) r5.L$2;
        Job r76 = (Job) r5.L$1;
        l0 r120 = (l0) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L21
        r4 = "execute: fetchBitmap result=";
    L371:
    L186:
        th = th;
        r15 = r76;
    L188:
        r14 = r120;
        goto L349
    L176:
        if (((Boolean) r0).booleanValue() == true) goto L185;
        FLogger.a.e("MarkAction", "execute: raw image load failed or timeout");     // Catch: Throwable -> L186
        t19.s r77 = t19.s.a;     // Catch: Throwable -> L186
        OriginalImagePreloader r78 = OriginalImagePreloader.a;     // Catch: Throwable -> L186
        r77.getClass();     // Catch: Throwable -> L186
        t19.s.b(r74, 2131899435, false);     // Catch: Throwable -> L186
        Unit r79 = Unit.INSTANCE;     // Catch: Throwable -> L186
        if (r76 == null) goto L180;
        Job.DefaultImpls.cancel$default(r76, null, 1, null);
    L180:
        PreviewToolbarView r80 = r120.f;
        if (r80 == null) goto L183;
        r80.a(this.e, false);
    L183:
        this.g = false;
        return r79;
    L185:
        Job r81 = r76;
    L369:
        r5.L$0 = r120;     // Catch: Throwable -> L347
        r5.L$1 = r81;     // Catch: Throwable -> L347
        r5.L$2 = r13;     // Catch: Throwable -> L347
        r5.L$3 = r119;     // Catch: Throwable -> L347
        r5.L$4 = r75;     // Catch: Throwable -> L347
        r5.L$5 = r74;     // Catch: Throwable -> L347
        r5.L$6 = r9;     // Catch: Throwable -> L347
        r5.L$7 = r3;     // Catch: Throwable -> L347
        r5.label = 3;     // Catch: Throwable -> L347
        r0 = c(r9, r75, r5);     // Catch: Throwable -> L347
        if (r0 != r7) goto L194;
        return r7;
    L194:
        r10 = r74;
        r11 = r75;
        r14 = r120;
        r12 = r119;
        r15 = r81;
    L347:
        th = th;
        r15 = r81;
    L21:
        th = th;
        l0 r121 = r120;
    L28:
        r2 = r121;
        r15 = r76;
        goto L352
    L23:
        IFlowCamera r82 = (IFlowCamera) r5.L$6;
        FragmentActivity r83 = (FragmentActivity) r5.L$5;
        String r84 = (String) r5.L$4;
        String r85 = (String) r5.L$3;
        r13 = (xy8.d) r5.L$2;
        Job r122 = (Job) r5.L$1;
        r121 = (l0) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L26
        r4 = "execute: fetchBitmap result=";
    L366:
        String r86 = (String) r0;     // Catch: Throwable -> L158
        r75 = r84;
        r81 = r122;
        r74 = r83;
        r9 = r82;
        r2 = r121;
        r119 = r85;
    L162:
        if (r119 != null) goto L360;
    L169:
        boolean r87 = true;
    L170:
        if (r87 == true) goto L190;
        OriginalImagePreloader r88 = OriginalImagePreloader.a;     // Catch: Throwable -> L167
        r5.L$0 = r2;     // Catch: Throwable -> L167
        r5.L$1 = r81;     // Catch: Throwable -> L167
        r5.L$2 = r13;     // Catch: Throwable -> L167
        r5.L$3 = r119;     // Catch: Throwable -> L167
        r5.L$4 = r75;     // Catch: Throwable -> L167
        r5.L$5 = r74;     // Catch: Throwable -> L167
        r5.L$6 = r9;     // Catch: Throwable -> L167
        r5.L$7 = r86;     // Catch: Throwable -> L167
        r5.label = 2;     // Catch: Throwable -> L167
        Object r89 = r88.b(r119, "MarkAction#raw", r5);     // Catch: Throwable -> L167
        if (r89 != r7) goto L174;
        return r7;
    L174:
        r120 = r2;
        r3 = r86;
        r0 = r89;
        r76 = r81;
    L167:
        th = th;
        r15 = r81;
        goto L352
    L190:
        r120 = r2;
        r3 = r86;
        goto L369
    L360:
        if (r119.length() == 0) goto L169;
        r87 = false;
    L158:
        th = th;
        r14 = r121;
        r15 = r122;
    L26:
        th = th;
        r76 = r122;
        goto L28
    L29:
        ResultKt.throwOnFailure(r0);
        if (this.g == false) goto L33;
        FLogger.a.i("MarkAction", "execute ignored: mark page is launching");
        return Unit.INSTANCE;
    L33:
        this.g = true;
        r13 = r2.a;     // Catch: Throwable -> L350
        d(r2, r13);     // Catch: Throwable -> L350
        int r90 = b.a[r13.e.ordinal()];     // Catch: Throwable -> L350
        if (r90 == 1) goto L41;
        if (r90 != 2) goto L44;
        xy8.g r91 = r13.d;     // Catch: Throwable -> L350
        if (r91 == null) goto L44;
        String r92 = r91.d;     // Catch: Throwable -> L350
    L46:
        if (r13.e != GalleryType.Image) goto L57;
        xy8.b r93 = r13.c;     // Catch: Throwable -> L350
        if (r93 == null) goto L57;
        String r94 = r93.d;     // Catch: Throwable -> L350
        if (r94 == null) goto L57;
        if (r94.length() <= 0) goto L54;
        boolean r95 = true;
    L55:
        if (r95 == false) goto L57;
    L58:
        if (r92 != null) goto L60;
        String r96 = r94;
    L61:
        FLogger r123 = FLogger.a;     // Catch: Throwable -> L350
        StringBuilder r124 = new StringBuilder("execute: resourceType=");     // Catch: Throwable -> L350
        r124.append(r13.e);     // Catch: Throwable -> L350
        r124.append(", hasImage=");     // Catch: Throwable -> L350
        if (r92 != null) goto L64;
    L67:
        boolean r97 = true;
    L68:
        if (r97 == true) goto L70;
        boolean r98 = true;
    L71:
        r124.append(r98);     // Catch: Throwable -> L350
        r124.append(", hasRawImage=");     // Catch: Throwable -> L350
        if (r94 == null) goto L74;
        boolean r99 = true;
    L75:
        r124.append(r99);     // Catch: Throwable -> L350
        r123.i("MarkAction", r124.toString());     // Catch: Throwable -> L350
        FragmentActivity r100 = r26.getContext();     // Catch: Throwable -> L350
        if ((r100 instanceof FragmentActivity) == false) goto L78;
        FragmentActivity r101 = r100;     // Catch: Throwable -> L350
    L79:
        if (r101 != null) goto L86;
        r123.e("MarkAction", "context is not FragmentActivity, abort");     // Catch: Throwable -> L350
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L350
        PreviewToolbarView r103 = r2.f;
        if (r103 == null) goto L84;
        r103.a(this.e, false);
    L84:
        this.g = false;
        return r102;
    L86:
        r9 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);     // Catch: Throwable -> L350
        if (r9 != null) goto L94;
        r123.e("MarkAction", "IFlowCamera service not found, abort");     // Catch: Throwable -> L350
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L350
        PreviewToolbarView r105 = r2.f;
        if (r105 == null) goto L92;
        r105.a(this.e, false);
    L92:
        this.g = false;
        return r104;
    L94:
        String r125 = f(r13);     // Catch: Throwable -> L350
        xy8.b r126 = r13.c;     // Catch: Throwable -> L350
        if (r126 != null) goto L97;
    L114:
        String r106 = null;
    L115:
        xy8.b r127 = r13.c;     // Catch: Throwable -> L350
        if (r127 == null) goto L118;
        boolean r128 = Intrinsics.areEqual(r127.e, Boxing.boxBoolean(true));     // Catch: Throwable -> L350
    L119:
        if (r128 == false) goto L129;
        if (r106 != null) goto L129;
        if (r125 != null) goto L123;
    L126:
        boolean r129 = true;
    L127:
        if (r129 == true) goto L129;
        boolean r130 = true;
    L130:
        if (r130 == true) goto L140;
        if (r94 != null) goto L133;
    L136:
        boolean r131 = true;
    L137:
        if (r131 == false) goto L140;
        r81 = null;
    L141:
        if (r106 != null) goto L161;
        if (r130 == false) goto L160;
        if (r125 != null) goto L362;
    L150:
        boolean r107 = true;
    L151:
        if (r107 == true) goto L160;
        r5.L$0 = r2;     // Catch: Throwable -> L148
        r5.L$1 = r81;     // Catch: Throwable -> L148
        r5.L$2 = r13;     // Catch: Throwable -> L148
        r5.L$3 = r94;     // Catch: Throwable -> L148
        r5.L$4 = r96;     // Catch: Throwable -> L148
        r5.L$5 = r101;     // Catch: Throwable -> L148
        r5.L$6 = r9;     // Catch: Throwable -> L148
        r5.label = 1;     // Catch: Throwable -> L148
        Object r108 = e(r125, r5);     // Catch: Throwable -> L148
        if (r108 != r7) goto L155;
        return r7;
    L155:
        r121 = r2;
        r82 = r9;
        r122 = r81;
        r83 = r101;
        r0 = r108;
        String r210 = r96;
        r85 = r94;
        r84 = r210;
    L148:
        th = th;
        r14 = r2;
        r15 = r81;
        goto L349
    L362:
        if (r125.length() == 0) goto L150;
        r107 = false;
    L160:
        r119 = r94;
        r75 = r96;
        r74 = r101;
        r86 = null;
        goto L162
    L161:
        r119 = r94;
        r74 = r101;
        r86 = r106;
        r75 = r96;
        goto L162
    L133:
        if (r94.length() == 0) goto L136;
        r131 = false;
    L140:
        r81 = BuildersKt.launch$default(r2.b, null, null, new MarkAction$startLoadingJob$1(r2, this, null), 3, null);     // Catch: Throwable -> L350
        goto L141
    L123:
        if (r125.length() == 0) goto L126;
        r129 = false;
    L129:
        r130 = false;
        goto L130
    L118:
        r128 = false;
        goto L119
    L97:
        if (Intrinsics.areEqual(r126.e, Boxing.boxBoolean(true)) == true) goto L99;
    L101:
        boolean r109 = false;
    L102:
        if (r109 == true) goto L105;
        r126 = null;
    L105:
        if (r126 == null) goto L114;
        r106 = r126.g;     // Catch: Throwable -> L350
        if (r106 == null) goto L114;
        if (r106.length() <= 0) goto L111;
        boolean r132 = true;
    L112:
        if (r132 == false) goto L114;
    L111:
        r132 = false;
        goto L112
    L99:
        if (CreationNoWatermarkManager.a.D() == false) goto L101;
        r109 = true;
        goto L102
    L78:
        r101 = null;
        goto L79
    L74:
        r99 = false;
        goto L75
    L70:
        r98 = false;
        goto L71
    L64:
        if (StringsKt.isBlank(r92) == true) goto L67;
        r97 = false;
        goto L68
    L60:
        r96 = r92;
        goto L61
    L54:
        r95 = false;
    L57:
        r94 = null;
    L44:
        r92 = null;
        goto L46
    L41:
        xy8.b r133 = r13.c;     // Catch: Throwable -> L350
        if (r133 == null) goto L44;
        r92 = r133.a;     // Catch: Throwable -> L350
    L350:
        th = th;
        r15 = null;
    L7:
        r5 = new MarkAction$execute$1(this, r27);
        goto L8
    }

    public final boolean b(FragmentActivity r5, xy8.d r6) {
        com.larus.chat.gallery.api.q r0 = this.c;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.Oa(r6.b) == false) goto L8;
        return true;
    L8:
        PreviewSelectionLimit r2 = r0.e(r6.b);
        if (r2 == null) goto L21;
        int r7 = b.b[r2.b.ordinal()];
        if (r7 != 1) goto L13;
        int r8 = 2131907895;
    L18:
        t19.s r1 = t19.s.a;
        String r9 = r5.getString(r8, new Object[]{String.valueOf(r2.a)});
        r1.getClass();
        t19.s.t(r5, r9);
        return false;
    L13:
        if (r7 != 2) goto L16;
        r8 = 2131910955;
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L21:
        return r0.w(r6.b);
    }

    public final Object e(String r7, Continuation<? super String> r8) {
        if ((r8 instanceof MarkAction$resolveDownloadWatermarkUrl$1) == false) goto L7;
        MarkAction$resolveDownloadWatermarkUrl$1 r0 = (MarkAction$resolveDownloadWatermarkUrl$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22 CancellationException -> L54
    L20:
        com.larus.network.http.a r10 = (com.larus.network.http.a) r9;     // Catch: Throwable -> L22 CancellationException -> L54
    L24:
        if (r10 == null) goto L28;
        SignImgWmData r11 = (SignImgWmData) r10.b;
        if (r11 == null) goto L28;
        Map<String, SignImgWmImageData> r12 = r11.getImages();
    L29:
        if (r12 == null) goto L36;
        SignImgWmImageData r13 = r12.get(r7);
        if (r13 == null) goto L36;
        SignImgWmImageObj r14 = r13.getImageOri();
        if (r14 == null) goto L36;
        String r15 = r14.getUrl();
        if (r15 == null) goto L36;
    L45:
        if (r15 != null) goto L47;
    L50:
        if (r4 == false) goto L53;
        FLogger.a.w("MarkAction", "resolveDownloadWatermarkUrl: empty watermark url");
        return null;
    L53:
        return r15;
    L47:
        if (r15.length() == 0) goto L50;
        r4 = false;
    L36:
        if (r12 == null) goto L44;
        Collection<SignImgWmImageData> r16 = r12.values();
        if (r16 == null) goto L44;
        SignImgWmImageData r17 = (SignImgWmImageData) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L44;
        SignImgWmImageObj r18 = r17.getImageOri();
        if (r18 == null) goto L44;
        r15 = r18.getUrl();
    L44:
        r15 = null;
    L28:
        r12 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        List r19 = CollectionsKt.listOf(r7);     // Catch: Throwable -> L22 CancellationException -> L54
        r0.L$0 = r7;     // Catch: Throwable -> L22 CancellationException -> L54
        r0.label = 1;     // Catch: Throwable -> L22 CancellationException -> L54
        r9 = j0.a(r19, r0);     // Catch: Throwable -> L22 CancellationException -> L54
        if (r9 != r2) goto L20;
        return r2;
    L54:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        FLogger.a.e("MarkAction", "resolveDownloadWatermarkUrl: sign_img_wm failed", th);
        r10 = null;
    L7:
        r0 = new MarkAction$resolveDownloadWatermarkUrl$1(this, r8);
        goto L8
    }

    public final Object c(IFlowCamera r8, String r9, Continuation<? super Bitmap> r10) {
        if ((r10 instanceof MarkAction$fetchMarkBitmap$1) == false) goto L7;
        MarkAction$fetchMarkBitmap$1 r0 = (MarkAction$fetchMarkBitmap$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L21;
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L19;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14 CancellationException -> L16
    L59:
    L66:
        return (Bitmap) r11;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r9 = r12;
    L53:
        Bitmap r13 = (Bitmap) r11;
        if (r13 == null) goto L56;
        return r13;
    L56:
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L16
        MarkAction$fetchMarkBitmap$6 r15 = new MarkAction$fetchMarkBitmap$6(r9, null);     // Catch: Throwable -> L14 CancellationException -> L16
        r0.L$0 = null;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.label = 2;     // Catch: Throwable -> L14 CancellationException -> L16
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r11 != r2) goto L59;
        return r2;
    L21:
        ResultKt.throwOnFailure(r11);
        if (r9 != null) goto L24;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == false) goto L30;
        return null;
    L30:
        com.larus.chat.gallery.impl.preview.datasource.n.a.getClass();
        String r17 = com.larus.chat.gallery.impl.preview.datasource.n.c(r9);
        Bitmap r4 = r8.q(r9);
        if (r4 != null) goto L33;
    L38:
        if (r17 != null) goto L40;
    L49:
        if (r17 == null) goto L56;
        CoroutineDispatcher r18 = Dispatchers.getIO();
        MarkAction$fetchMarkBitmap$localBitmap$1 r5 = new MarkAction$fetchMarkBitmap$localBitmap$1(r17, null);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r18, r5, r0);
        if (r11 != r2) goto L53;
        return r2;
    L40:
        if (Intrinsics.areEqual(r17, r9) == true) goto L49;
        Bitmap r19 = r8.q(r17);
        if (r19 == null) goto L49;
        if (r19.isRecycled() == false) goto L47;
        r19 = null;
    L47:
        if (r19 == null) goto L49;
        return r19;
    L33:
        if (r4.isRecycled() == false) goto L36;
        r4 = null;
    L36:
        if (r4 == null) goto L38;
        return r4;
    L24:
        if (r9.length() == 0) goto L27;
        r16 = false;
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        FLogger.a.e("MarkAction", "fetchMarkBitmap: fetch bitmap failed", th);
        return null;
    L7:
        r0 = new MarkAction$fetchMarkBitmap$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarkAction(PreviewCameraParamProvider r2, com.larus.chat.gallery.impl.preview.input.e0 r3, com.larus.chat.gallery.api.q r4, AttachmentEditType r5, ToolbarButtonType r6, Function1<? super xy8.d, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r2, "paramProvider");
        Intrinsics.checkNotNullParameter(r5, "editType");
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        Intrinsics.checkNotNullParameter(r7, "supportsCrop");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
