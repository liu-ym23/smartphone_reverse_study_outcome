package wn8;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.standarduikit.videogroup.view.RelatedVideoView;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.RelatedVideoViewModel;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.e;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.b0;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import oi8.j;
import v19.i5;
import zn8.d;
import zn8.f;
import zn8.l;
import zn8.p;
import zn8.q;
import zn8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Lazy a;
    public final Lazy b;

    public final RelatedVideoView b() {
        return (RelatedVideoView) this.a.getValue();
    }

    public c(final Context r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2, r3));
        this.b = LazyKt.lazy(new b());
    }

    public final void a(com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r25, e r26) {
        Intrinsics.checkNotNullParameter(r25, "vmData");
        ((RelatedVideoViewModel) this.b.getValue()).a(r25, r26);
        RelatedVideoViewModel r1 = (RelatedVideoViewModel) this.b.getValue();
        q r2 = (q) CollectionsKt.firstOrNull(r1.a.b);
        l r4 = r1.a.a;
        if (r2 != null) goto L5;
        r2 = new q.a().a();
    L5:
        r r3 = new r(r4, r2, new p(r1.a.a()), AppHost.a.isOversea());
        final RelatedVideoViewModel.b r5 = (RelatedVideoViewModel.b) ((RelatedVideoViewModel) this.b.getValue()).d.getValue();
        final RelatedVideoView r6 = b();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r5, "output");
        l r7 = r3.a;
        Pair r8 = RelatedVideoView.a(r7);
        int r9 = ((Number) r8.component1()).intValue();
        int r10 = ((Number) r8.component2()).intValue();
        int r11 = r6.getPaddingStart();
        int r12 = r6.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:RelatedVideoView,source:,start:" + r11 + ",top:" + r9 + ",end:" + r12 + ",bottom:" + r10);
        r6.setPaddingRelative(r11, r9, r12, r10);
        if (r7.c == false) goto L8;
        int r13 = r6.b;
    L9:
        ViewGroup r14 = r6.getContentView();
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L71;
        r15.height = r6.getWidgetHeight() + r13;
        r14.setLayoutParams(r15);
        Uri r16 = null;
        r6.getContentView().setBackground(null);
        final q r17 = r3.b;
        boolean r18 = r3.d;
        p r19 = r3.c;
        if (r18 == false) goto L44;
        final String r20 = r17.c;
        String r21 = r17.f;
        if (r21 != null) goto L16;
    L19:
        boolean r22 = true;
    L20:
        if (r22 == false) goto L22;
        String r23 = r17.e;
    L23:
        String r110 = r23;
        if (r20 != null) goto L26;
    L29:
        boolean r24 = true;
    L30:
        if (r24 == false) goto L32;
        r6.getCiciSourceIcon().setVisibility(8);
    L43:
        e1.d(r6.getCiciSourceIcon(), new zn8.b(r20, r5, r6, r17));
        r6.getDySourceLabelView().setVisibility(8);
    L48:
        final q r27 = r3.b;
        boolean r28 = r3.d;
        p r29 = r3.c;
        if (Intrinsics.areEqual(r27.j, Boolean.TRUE) == false) goto L51;
        r6.getCoverView().setHierarchy(new GenericDraweeHierarchyBuilder(r6.getContext().getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        ViewParent r111 = r6.getCoverView().getParent();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r111).getBackground().setTint(ContextCompat.getColor(r6.getContext(), 2131103292));
    L51:
        ViewGroup.LayoutParams r112 = r6.getCoverView().getLayoutParams();
        Intrinsics.checkNotNull(r112);
        MessageImageLoader r113 = MessageImageLoader.a;
        String r114 = r29.a;
        MessageImageType r115 = MessageImageType.VIDEO;
        SimpleDraweeView r116 = r6.getCoverView();
        String r30 = r27.g;
        if (r30 == null) goto L54;
        r16 = b0.a(r30, "markdown.video_group_cover_thumb", true, false, 4);
    L54:
        String r31 = y0.k(r16);
        String r32 = "";
        if (r31 != null) goto L57;
        String r117 = "";
    L58:
        IMessageImageLoaderService.a.b(r113, r114, r115, r116, r117, "", Integer.valueOf(r112.width), Integer.valueOf(r112.height), new zn8.c(r6, r27), null, null, false, 1792);
        r6.getCoverView().setTag(2131364614, "a35794.b83401.c108514.d108515");
        e1.d(r6.getCoverView(), new d(r27, r5, r6));
        r6.getCoverView().setOnLongClickListener(new zn8.e(r5));
        if (r28 == true) goto L61;
        SimpleDraweeView r33 = r6.getCoverView();
        StringCompanionObject r34 = StringCompanionObject.INSTANCE;
        int r35 = j0.a;
        r33.setContentDescription(String.format(j0.d(2131898847), Arrays.copyOf(new Object[]{r27.k}, 1)));
    L61:
        ExposeXTrackerExtKt.b(r6.getCoverView(), new f(r27, r5, r6));
        String r36 = r3.b.l;
        if (r3.a.c == true) goto L64;
        e1.o(r6.getTitleView());
        return;
    L64:
        e1.x(r6.getTitleView());
        we8.a.b(r6.getTitleView(), i5.t(), false, null, null, 12);
        r6.getTitleView().getLayoutParams().height = (int) we8.a.a(((Number) i5.y.getValue()).intValue(), false);
        TextView r37 = r6.getTitleView();
        if (r36 == null) goto L68;
        r32 = r36;
    L68:
        r37.setText(r32);
        return;
    L57:
        r117 = r31;
        goto L58
    L32:
        r6.getCiciSourceIcon().setVisibility(0);
        if (r110 != null) goto L35;
    L38:
        boolean r38 = true;
    L40:
        if (r38 == false) goto L42;
        r6.getCiciSourceIcon().setImageResource(2131242994);
        goto L43
    L42:
        r6.getCiciSourceIcon().getHierarchy().setFailureImage(2131242994);
        int r39 = j.a;
        j.b(r6.getCiciSourceIcon(), r110, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 992);
        goto L43
    L35:
        if (r110.length() == 0) goto L38;
        r38 = false;
        goto L40
    L26:
        if (r20.length() == 0) goto L29;
        r24 = false;
        goto L30
    L22:
        r23 = r17.f;
        goto L23
    L16:
        if (r21.length() == 0) goto L19;
        r22 = false;
        goto L20
    L44:
        String r118 = r17.e;
        if (r118 == null) goto L47;
        r6.getDySourceLabelView().setVisibility(0);
        IMessageImageLoaderService.a.b(MessageImageLoader.a, r19.a, MessageImageType.IMAGE, r6.getDySourceLabelView(), r118, "markdown.media_source_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        goto L48
    L47:
        r6.getDySourceLabelView().setVisibility(8);
        goto L48
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r13 = 0;
        goto L9
    }
}
