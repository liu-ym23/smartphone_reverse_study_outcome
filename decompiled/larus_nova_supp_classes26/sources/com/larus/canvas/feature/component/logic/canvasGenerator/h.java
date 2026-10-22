package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.ICanvasRepoService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.FeatureOptionPanelItem;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.canvas.service.bean.TabExtra;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import cy8.l;
import cy8.m;
import cy8.q;
import cy8.v;
import cy8.w;
import cy8.x;
import cy8.y;
import hq9.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.CallbackFlowBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements j {
    public static final h a = null;
    public static final long b = 0;
    public static final Lazy c = null;
    public static final ConcurrentHashMap<String, ny8.j> d = null;

    public h() {
    }

    static {
        a = new h();
        b = z2.a.getCreationCanvasClientConfig().a;
        c = LazyKt.lazy(new a());
        d = new ConcurrentHashMap();
    }

    public static by8.a e() {
        pd6.b r0 = pd6.c.a;
        return pd6.c.a(Reflection.getOrCreateKotlinClass(by8.a.class));
    }

    @Override // com.larus.canvas.feature.component.logic.canvasGenerator.j
    public final void b(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "localIds");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        String r0 = (String) r6.next();
        ny8.j r1 = d.remove(r0);
        if (r1 == null) goto L4;
        r1.cancel();
        FLogger.a.i("CanvasGenerator", "cancel task " + r0);
        goto L4
    }

    @Override // com.larus.canvas.feature.component.logic.canvasGenerator.j
    public final CallbackFlowBuilder a(ky8.c r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "requestParam");
        return kotlinx.coroutines.flow.e.e(new CanvasGenerator$startStreamGenerate$1(r3, r4, null));
    }

    public static final Object c(ky8.c r37, CanvasGenerator$startStreamGenerate$1.b r38, Continuation r39) {
        by8.a r2 = e();
        if (r2 != null) goto L5;
        FLogger.a.e("CanvasGenerator", "SSE_KMP ability not registered, report error, localId=" + r37.c);
        r38.onError(-90001, "ICanvasSSEAbility kmpService is null");
        return Unit.INSTANCE;
    L5:
        int r3 = i.a;
        Intrinsics.checkNotNullParameter(r37, "param");
        r0 r4 = z2.a.getCreationCanvasClientConfig();
        String r6 = r37.c;
        Intrinsics.checkNotNullParameter(r37, "param");
        StringBuilder r5 = new StringBuilder();
        r5.append(r37.a);
        r5.append('_');
        r5.append(r37.b);
        String r7 = r5.toString();
        Long r9 = r37.d;
        Long r10 = r37.e;
        Integer r11 = Integer.valueOf(r37.a);
        Integer r12 = Integer.valueOf(r37.b);
        String r13 = r37.c;
        String r14 = r37.j;
        String r15 = r37.k;
        String r8 = r37.l;
        List<InstructionTab> r16 = r37.f;
        if (r16 == null) goto L51;
        List<InstructionTab> r17 = r16;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r18 = r17.iterator();
    L9:
        if (r18.hasNext() == false) goto L50;
        InstructionTab r19 = (InstructionTab) r18.next();
        String r25 = r19.getTabLabel();
        String r26 = r19.getTabName();
        Integer r27 = r19.getTabType();
        TabExtra r110 = r19.getExtra();
        if (r110 == null) goto L13;
        y r28 = new y(r110.isSupportRefImage(), r110.getEffectMode(), r110.getAbilityType());
    L14:
        Icon r20 = r19.getIcon();
        if (r20 == null) goto L17;
        m r29 = i.a(r20);
    L18:
        Icon r21 = r19.getDarkModeIcon();
        if (r21 == null) goto L21;
        m r30 = i.a(r21);
    L22:
        List<OptionItem> r22 = r19.getOptionList();
        if (r22 == null) goto L29;
        List<OptionItem> r23 = r22;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r31 = r23.iterator();
    L26:
        if (r31.hasNext() == false) goto L28;
        r24.add(i.b((OptionItem) r31.next()));
        goto L26
    L28:
        ArrayList r32 = r24;
    L30:
        OptionItem r33 = r19.getSingleOption();
        if (r33 == null) goto L33;
        q r34 = i.b(r33);
    L34:
        List<FeatureOptionPanelItem> r35 = r19.getFeatureOptionPanelList();
        if (r35 == null) goto L48;
        List<FeatureOptionPanelItem> r36 = r35;
        ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator r41 = r36.iterator();
    L38:
        if (r41.hasNext() == false) goto L47;
        FeatureOptionPanelItem r42 = (FeatureOptionPanelItem) r41.next();
        Long r43 = r42.getId();
        String r44 = r42.getTitle();
        List<OptionItem> r45 = r42.getOptionList();
        if (r45 == null) goto L45;
        List<OptionItem> r46 = r45;
        ArrayList r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));
        Iterator<T> r48 = r46.iterator();
    L43:
        if (r48.hasNext() == false) goto L46;
        r47.add(i.b((OptionItem) r48.next()));
    L46:
        r40.add(new cy8.f(r43, r44, r47));
        r41 = r41;
        r8 = r8;
        r4 = r4;
        goto L38
    L45:
        r47 = null;
        goto L46
    L47:
        String r210 = r8;
        r0 r310 = r4;
        ArrayList r311 = r40;
    L49:
        r1.add(new l(r25, r26, r27, r28, r29, r30, r32, r34, r311));
        r18 = r18;
        r8 = r210;
        r7 = r7;
        r6 = r6;
        r4 = r310;
        goto L9
    L48:
        r210 = r8;
        r310 = r4;
        r311 = null;
        goto L49
    L33:
        r34 = null;
        goto L34
    L29:
        r32 = null;
        goto L30
    L21:
        r30 = null;
        goto L22
    L17:
        r29 = null;
        goto L18
    L13:
        r28 = null;
        goto L14
    L50:
        String r211 = r8;
        r0 r312 = r4;
        String r313 = r6;
        String r314 = r7;
        ArrayList r111 = r1;
    L52:
        ImageObject r49 = r37.g;
        cy8.j r112 = new cy8.j(r49.uri, r49.url, r49.width, r49.height, r49.urlFormats, r49.aiCreationImage);
        String r50 = r37.h;
        String r51 = r37.m;
        List<ImageObject> r52 = r37.i;
        if (r52 == null) goto L59;
        List<ImageObject> r53 = r52;
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
        Iterator r55 = r53.iterator();
    L56:
        if (r55.hasNext() == false) goto L58;
        ImageObject r56 = (ImageObject) r55.next();
        r54.add(new cy8.j(r56.uri, r56.url, r56.width, r56.height, r56.urlFormats, r56.aiCreationImage));
        r55 = r55;
        r51 = r51;
        goto L56
    L58:
        String r212 = r51;
    L60:
        v r0 = new v(r9, r10, r11, r12, r13, r14, r15, r211, r111, r112, r50, r212, r54, 256);
        r0 r57 = r312;
        Object r58 = r2.n2(new w(r313, r314, r0, new x(r57.d, r57.e, r57.f, r57.g), r57.b)).collect(new b(r38, r37), r39);
        if (r58 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
        return r58;
    L64:
        return Unit.INSTANCE;
    L59:
        r212 = r51;
        r54 = null;
        goto L60
    L51:
        r211 = r8;
        r312 = r4;
        r313 = r6;
        r314 = r7;
        r111 = null;
        goto L52
    }

    public static final void d(String r4, ny8.c r5, List r6) {
        r5.a(r6);
        FLogger.a.i("CanvasGenerator", "sse done but block not finished, getCanvasBlockInfo trigger, localId = " + r4);
        ICanvasRepoService.Companion r0 = ICanvasRepoService.a;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r6);
        Long r2 = null;
        if (r1 == null) goto L9;
        CanvasImageBlock r3 = r1.content;
        if (r3 == null) goto L9;
        CanvasInfo r7 = r3.canvasInfo;
        if (r7 == null) goto L9;
        Long r8 = r7.canvasId;
    L10:
        CanvasBlock r9 = (CanvasBlock) CollectionsKt.firstOrNull(r6);
        if (r9 == null) goto L17;
        CanvasImageBlock r10 = r9.content;
        if (r10 == null) goto L17;
        CanvasInfo r11 = r10.canvasInfo;
        if (r11 == null) goto L17;
        r2 = r11.canvasSubId;
    L17:
        r0.b(new ny8.f(r8, r2, r4), new c(r4, r5, r6));
        return;
    L9:
        r8 = null;
        goto L10
    }
}
