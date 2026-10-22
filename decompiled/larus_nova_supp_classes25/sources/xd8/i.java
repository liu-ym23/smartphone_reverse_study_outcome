package xd8;

import android.content.res.Resources;
import android.text.TextPaint;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.platform.api.f3;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import dg8.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements td8.b {
    public static Integer b;
    public final Lazy a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TextCellCutType.values().length];
            r0[TextCellCutType.DeepThinkCutMultipleCell.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TextCellCutType.NewCutThreeTextCell.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // td8.b
    public final void b() {
    }

    static {
        gw8.c.a.getClass();
        gw8.c r1 = gw8.c.a.b();
        lw8.h r0 = null;
        if (r1 == null) goto L5;
        lw8.h r2 = r1.createCacheMarkwonStruct(AppHost.a.getApplication(), null, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, false);
    L7:
        if ((r2 instanceof MarkwonStruct) == false) goto L9;
        MarkwonStruct r3 = (MarkwonStruct) r2;
    L9:
        gw8.c r4 = gw8.c.a.b();
        if (r4 == null) goto L13;
        r0 = r4.createCacheMarkwonStruct(AppHost.a.getApplication(), null, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, true);
    L13:
        if ((r0 instanceof MarkwonStruct) == false) goto L16;
        MarkwonStruct r5 = (MarkwonStruct) r0;
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.TRANSFORM_TO_MARK_WIDGET;
    }

    public i(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = LazyKt.lazy(new h(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r17) {
        Intrinsics.checkNotNullParameter(r17, "input");
        List r1 = CollectionsKt.toMutableList(r17.a);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L65;
        xc8.b r4 = (xc8.b) r3.next();
        if ((r4 instanceof l) == true) goto L7;
        r2.add(r4);
        goto L4
    L7:
        int r5 = b.a[((TextCellCutType) this.a.getValue()).ordinal()];
        if (r5 != 1) goto L10;
        r2.add(r4);
        goto L4
    L10:
        if (r5 != 2) goto L11;
        List<TextTagInfo> r6 = com.larus.bmhome.chat.bean.d.O(r4.getMessage());
        if (r6 == null) goto L25;
        List<TextTagInfo> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L25;
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value), Integer.valueOf(TagEnum.TagEnum_InsertText_Lynx.value), Integer.valueOf(TagEnum.TagEnum_InsertText_APPLET.value)}).contains(Integer.valueOf(((TextTagInfo) r8.next()).type)) == false) goto L21;
        boolean r9 = true;
    L26:
        int r10 = wf9.b.a;
        Message r11 = r4.getMessage();
        Intrinsics.checkNotNullParameter(r11, "message");
        String r12 = com.larus.im.bean.message.a.K(r11);
        if (r12 == null) goto L29;
        int r13 = r12.length();
    L30:
        Integer r14 = b;
        if (r14 != null) goto L38;
        TextPaint r15 = new TextPaint();
        r15.setTextSize(we8.a.a(i5.o(), false));
        float r16 = r15.measureText("..");
        float r18 = r15.measureText("...") - r16;
        if (e2.a.isPad() == false) goto L36;
        Resources r19 = AppHost.a.getApplication().getResources();
        int r110 = RangesKt.coerceAtMost(WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics()).widthPixels, f3.a.a());
    L37:
        r14 = Integer.valueOf((int) (((r110 - r16) / r18) + 2));
        b = r14;
        goto L38
    L36:
        Resources r111 = AppHost.a.getApplication().getResources();
        r110 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).widthPixels;
    L38:
        if (r14 == null) goto L40;
        int r112 = r14.intValue();
        FLogger.a.i("TransformToMarkWidgetTask", "getMaxContentLength: " + r112);
        int r113 = r14.intValue();
    L41:
        if (r13 < r113) goto L43;
        boolean r114 = true;
    L44:
        if (r13 == 0) goto L46;
        boolean r20 = true;
    L47:
        if (r9 == true) goto L49;
        if (r114 == true) goto L49;
    L51:
        boolean r21 = false;
    L52:
        if (r21 == true) goto L53;
        r2.add(r4);
        goto L4
    L53:
        l r22 = (l) r4;
        ArrayList r23 = new ArrayList();
        List r24 = CollectionsKt.listOf(new gg8.g(r22.a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.TOP_CELL_COMPONENT, 0, 1, 56)));
        int r115 = r24.size() + 2;
        List r25 = r24;
        Iterator r116 = r25.iterator();
        int r117 = 0;
    L55:
        if (r116.hasNext() == false) goto L60;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        com.larus.bmhome.chat.list.cell.text.cells.base.a r120 = (com.larus.bmhome.chat.list.cell.text.cells.base.a) r118;
        r120.i().d = r117;
        r120.i().e = r115;
        r117 = r119;
        goto L55
    L60:
        fg8.f r26 = new fg8.f(r22.a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.MIDDLE_CELL_COMPONENT, 0, 1, 56));
        r26.g.d = r24.size();
        r26.g.e = r115;
        eg8.g r121 = new eg8.g(r22.a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.BOTTOM_CELL_COMPONENT, 0, 1, 56));
        r121.g.d = r24.size() + 1;
        r121.g.e = r115;
        r23.add(r121);
        r23.add(r26);
        r23.addAll(CollectionsKt.reversed(r25));
        r2.addAll(CollectionsKt.toMutableList(r23));
    L49:
        if (r20 == false) goto L51;
        r21 = true;
        goto L52
    L46:
        r20 = false;
        goto L47
    L43:
        r114 = false;
        goto L44
    L40:
        r113 = Integer.MAX_VALUE;
        goto L41
    L29:
        r13 = 0;
        goto L30
    L17:
        if (r7.isEmpty() == false) goto L19;
    L25:
        r9 = false;
        goto L26
    L11:
        r2.add(r4);
        goto L4
    L65:
        return com.larus.bmhome.social.page.datasource.event.c.a(r17, r2, 0, null, null, 14);
    }
}
