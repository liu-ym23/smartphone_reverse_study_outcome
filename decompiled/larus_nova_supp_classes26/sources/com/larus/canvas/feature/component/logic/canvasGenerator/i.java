package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.bean.FilterConfItem;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.ImageInfo;
import com.larus.canvas.service.bean.MaskUri;
import com.larus.canvas.service.bean.MsgPromptConf;
import com.larus.canvas.service.bean.OptionExtra;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.canvas.service.bean.ParamFilterConf;
import com.larus.canvas.service.bean.PresetRefImage;
import com.larus.canvas.service.bean.PromptItem;
import com.larus.im.bean.message.ImageObj;
import cy8.m;
import cy8.o;
import cy8.p;
import cy8.q;
import cy8.r;
import cy8.s;
import cy8.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static m a(Icon r7) {
        return new m(r7.getUri(), r7.getUrl(), r7.getWidth(), r7.getHeight(), r7.getRadius());
    }

    public static q b(OptionItem r26) {
        long r1 = r26.getId();
        String r3 = r26.getDisplayText();
        String r4 = r26.getMessageText();
        Icon r0 = r26.getIcon();
        if (r0 == null) goto L5;
        m r6 = a(r0);
    L6:
        Icon r2 = r26.getDarkModeIcon();
        if (r2 == null) goto L9;
        m r7 = a(r2);
    L10:
        OptionExtra r5 = r26.getExtra();
        if (r5 == null) goto L25;
        Boolean r9 = r5.isPresetRefImage();
        PresetRefImage r8 = r5.getPresetRefImage();
        if (r8 == null) goto L23;
        Icon r11 = r8.getImageThumb();
        if (r11 == null) goto L17;
        m r12 = a(r11);
    L18:
        Icon r10 = r8.getImageOri();
        if (r10 == null) goto L21;
        m r13 = a(r10);
    L22:
        s r14 = new s(r12, r13);
    L24:
        p r15 = new p(r9, r14, r5.isTrending(), r5.getDetectMode(), r5.getSubDisplay(), r5.getOptionMsg());
    L26:
        String r16 = r26.getRedirectSchema();
        MaskUri r17 = r26.getMaskUri();
        if (r17 == null) goto L29;
        m r18 = new m(r17.getUri(), r17.getUrl(), r17.getWidth(), r17.getHeight(), r17.getRadius());
    L30:
        ParamFilterConf r19 = r26.getParamFilterConf();
        if (r19 == null) goto L40;
        List<FilterConfItem> r20 = r19.getConfList();
        if (r20 == null) goto L38;
        List<FilterConfItem> r21 = r20;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r22 = r21.iterator();
    L36:
        if (r22.hasNext() == false) goto L39;
        FilterConfItem r111 = (FilterConfItem) r22.next();
        r110.add(new cy8.g(r111.getMatchUiId(), r111.getOptionList(), r111.getDefaultOptionId()));
    L39:
        r r112 = new r(r110);
    L41:
        MsgPromptConf r23 = r26.getMsgPromptConf();
        if (r23 == null) goto L52;
        String r24 = r23.getPlaceholder();
        List<PromptItem> r113 = r23.getPromptList();
        if (r113 == null) goto L50;
        List<PromptItem> r114 = r113;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L47:
        if (r116.hasNext() == false) goto L49;
        PromptItem r117 = (PromptItem) r116.next();
        Iterator r118 = r116;
        r r119 = r112;
        r115.add(new t(r117.getFormat(), r117.getFormatType(), r117.getMatchUiId()));
        r116 = r118;
        r112 = r119;
        goto L47
    L49:
        r r120 = r112;
    L51:
        o r121 = new o(r24, r115, r23.getNoLimitPromptFormat());
    L53:
        ImageInfo r25 = r26.getIconOri();
        if (r25 == null) goto L56;
        m r122 = new m(r25.getUri(), r25.getUrl(), r25.getWidth(), r25.getHeight(), r25.getRadius());
    L57:
        ImageInfo r27 = r26.getPreviewIcon();
        if (r27 == null) goto L60;
        m r123 = new m(r27.getUri(), r27.getUrl(), r27.getWidth(), r27.getHeight(), r27.getRadius());
    L61:
        m r28 = r6;
        m r29 = r7;
        p r30 = r15;
        m r31 = r18;
        r r124 = r120;
        return new q(r1, r3, r4, r28, r29, r30, r16, r31, r124, r121, r122, r123, r26.getLanguage(), r26.getSourceMessageText(), r26.getTargetMessageText());
    L60:
        r123 = null;
        goto L61
    L56:
        r122 = null;
        goto L57
    L50:
        r120 = r112;
        r115 = null;
        goto L51
    L52:
        r120 = r112;
        r121 = null;
        goto L53
    L38:
        r110 = null;
        goto L39
    L40:
        r112 = null;
        goto L41
    L29:
        r18 = null;
        goto L30
    L21:
        r13 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    L23:
        r14 = null;
        goto L24
    L25:
        r15 = null;
        goto L26
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v0 com.larus.canvas.service.bean.CanvasImageBlock, still in use, count: 2, list:
          (r11v0 com.larus.canvas.service.bean.CanvasImageBlock) from 0x0088: MOVE (r33v0 com.larus.canvas.service.bean.CanvasImageBlock) = (r11v0 com.larus.canvas.service.bean.CanvasImageBlock) (LINE:16777352)
          (r11v0 com.larus.canvas.service.bean.CanvasImageBlock) from 0x008b: PHI (r33v1 com.larus.canvas.service.bean.CanvasImageBlock) = (r33v0 com.larus.canvas.service.bean.CanvasImageBlock), (r11v0 com.larus.canvas.service.bean.CanvasImageBlock) binds: [B:11:0x0084, B:10:0x005a] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public static com.larus.canvas.service.bean.CanvasBlock c(cy8.b r34) {
        java.lang.Integer r1 = r34.a;
        java.lang.String r2 = r34.b;
        cy8.a r3 = r34.e;
        if (r3 == null) goto L69;
        cy8.k r5 = r3.a;
        if (r5 == null) goto L11;
        java.lang.Long r13 = r5.a;
        java.lang.Long r14 = r5.b;
        java.lang.Integer r15 = r5.c;
        java.lang.Integer r6 = r5.d;
        java.lang.Long r7 = r5.e;
        java.lang.String r8 = r5.f;
        java.lang.Integer r9 = r5.g;
        java.lang.String r10 = r5.h;
        java.lang.Integer r12 = r5.i;
        cy8.d r4 = r5.j;
        if (r4 == null) goto L9;
        java.lang.Long r12 = r4.a;
        java.lang.Long r2 = r4.b;
        java.lang.Long r1 = r4.c;
        java.lang.Long r0 = r4.d;
        java.lang.Long r11 = r4.e;
        java.lang.Long r4 = r4.f;
        com.larus.canvas.service.bean.CostTime r23 = new com.larus.canvas.service.bean.CostTime(r12, r2, r1, r0, r11, r4);
        com.larus.canvas.service.bean.CostTime r22 = r23;
    L10:
        java.util.List<java.lang.String> r0 = r5.k;
        java.lang.Long r0 = r5.l;
        java.lang.Integer r0 = r5.m;
        com.larus.canvas.service.bean.CanvasInfo r0 = new com.larus.canvas.service.bean.CanvasInfo(r13, r14, r15, r6, r7, r8, r9, r10, r12, r22, r0, r0, r0, null, null, 24576, null);
        com.larus.canvas.service.bean.CanvasInfo r6 = r0;
    L12:
        cy8.i r0 = r3.b;
        if (r0 == null) goto L39;
        java.lang.String r8 = r0.a;
        cy8.j r2 = r0.b;
        if (r2 == null) goto L17;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r9 = r2;
    L18:
        cy8.j r2 = r0.c;
        if (r2 == null) goto L21;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r10 = r2;
    L22:
        cy8.j r2 = r0.d;
        if (r2 == null) goto L25;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r11 = r2;
    L26:
        cy8.j r2 = r0.e;
        if (r2 == null) goto L29;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r12 = r2;
    L30:
        cy8.j r2 = r0.f;
        if (r2 == null) goto L33;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r13 = r2;
    L34:
        cy8.j r2 = r0.g;
        if (r2 == null) goto L37;
        com.larus.im.bean.message.ImageObj r2 = d(r2);
        com.larus.im.bean.message.ImageObj r14 = r2;
    L38:
        java.lang.Integer r15 = r0.h;
        java.lang.String r2 = r0.i;
        java.lang.String r2 = r0.j;
        java.lang.String r2 = r0.k;
        java.lang.String r2 = r0.l;
        java.lang.String r0 = r0.m;
        com.larus.im.bean.message.ImageData r7 = new com.larus.im.bean.message.ImageData(r8, r9, r10, r11, r12, r13, r14, r15, null, r2, r2, r2, r2, r0, 256, null);
    L40:
        cy8.e r0 = r3.e;
        if (r0 == null) goto L43;
        java.lang.String r9 = r0.a;
        java.lang.Integer r10 = r0.b;
        com.larus.platform.api.creation.UserCreationFromIM r8 = new com.larus.platform.api.creation.UserCreationFromIM(r9, r10, null, null, null, null, null, 124, null);
    L44:
        cy8.h r0 = r3.d;
        if (r0 == null) goto L63;
        java.lang.String r10 = r0.a;
        java.lang.String r11 = r0.b;
        java.util.List<cy8.j> r1 = r0.c;
        if (r1 == null) goto L53;
        java.util.List<cy8.j> r1 = r1;
        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, 10);
        java.util.ArrayList r2 = new java.util.ArrayList(r4);
        java.util.Iterator<T> r1 = r1.iterator();
    L49:
        boolean r4 = r1.hasNext();
        if (r4 == false) goto L52;
        java.lang.Object r4 = r1.next();
        cy8.j r4 = (cy8.j) r4;
        com.larus.im.bean.message.ImageObj r4 = d(r4);
        r2.add(r4);
        goto L49
    L52:
        java.util.ArrayList r12 = r2;
    L54:
        cy8.j r1 = r0.d;
        if (r1 == null) goto L57;
        com.larus.im.bean.message.ImageObj r1 = d(r1);
        com.larus.im.bean.message.ImageObj r13 = r1;
    L58:
        cy8.j r0 = r0.e;
        if (r0 == null) goto L61;
        com.larus.im.bean.message.ImageObj r0 = d(r0);
        com.larus.im.bean.message.ImageObj r14 = r0;
    L62:
        com.larus.canvas.service.bean.CanvasGenerateData r9 = new com.larus.canvas.service.bean.CanvasGenerateData(r10, r11, r12, r13, r14);
    L64:
        cy8.n r0 = r3.c;
        if (r0 == null) goto L67;
        java.lang.String r1 = r0.a;
        java.lang.String r2 = r0.b;
        java.lang.String r0 = r0.c;
        com.larus.canvas.service.bean.CanvasMsgInfo r4 = new com.larus.canvas.service.bean.CanvasMsgInfo(r1, r2, r0);
        com.larus.canvas.service.bean.CanvasMsgInfo r10 = r4;
    L68:
        new com.larus.canvas.service.bean.CanvasImageBlock(r6, r7, r8, r9, r10);
        com.larus.canvas.service.bean.CanvasImageBlock r3 = r33;
    L70:
        boolean r4 = r34.d;
        java.lang.String r5 = r34.f;
        java.lang.Integer r1 = r32;
        java.lang.String r2 = r31;
        com.larus.canvas.service.bean.CanvasBlock r6 = new com.larus.canvas.service.bean.CanvasBlock(r1, r2, r3, r4, r5);
        return r6;
    L67:
        r10 = null;
        goto L68
    L61:
        r14 = null;
        goto L62
    L57:
        r13 = null;
        goto L58
    L53:
        r12 = null;
        goto L54
    L63:
        r9 = null;
        goto L64
    L43:
        r8 = null;
        goto L44
    L37:
        r14 = null;
        goto L38
    L33:
        r13 = null;
        goto L34
    L29:
        r12 = null;
        goto L30
    L25:
        r11 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L39:
        r7 = null;
        goto L40
    L9:
        r22 = null;
        goto L10
    L11:
        r32 = r1;
        r31 = r2;
        com.larus.canvas.service.bean.CanvasImageBlock r11 = r11;
        r6 = null;
        goto L12
    L69:
        r32 = r1;
        r31 = r2;
        r3 = null;
        goto L70
    }

    public static ImageObj d(cy8.j r9) {
        String r1 = r9.b;
        Integer r0 = r9.c;
        if (r0 == null) goto L5;
        int r3 = r0.intValue();
    L6:
        Integer r2 = r9.d;
        if (r2 == null) goto L9;
        int r4 = r2.intValue();
    L10:
        int r5 = r3;
        int r6 = r4;
        return new ImageObj(r1, r5, r6, r9.e, null, 16, null);
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
