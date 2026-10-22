package com.larus.uaigc.avatar.instruction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB,\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/avatar/instruction/HeaderComponent;", "offset", "", "getItemCount", "getItem", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemViewType", "Companion", "HeaderComponentBuilder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DigitalAvatarSelectorWidgetAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.f, RecyclerView.ViewHolder> {
    public static final DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final e a;
    public final h b;
    public final int c;

    public static final class a {
    }

    public static final class b {
        public Function1<? super ViewGroup, ? extends View> a;
        public final g b;

        public b() {
            this.a = new f();
            this.b = new g();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.avatar.instruction.DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new DigitalAvatarSelectorWidgetAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final int getItemCount() {
        return super.getItemCount() + this.c;
    }

    public final Object getItem(int r2) {
        return (com.larus.bmhome.actionbar.model.f) super.getItem(r2 - this.c);
    }

    public final int getItemViewType(int r2) {
        if (r2 >= this.c) goto L5;
        return 1;
    L5:
        return 0;
    }

    public DigitalAvatarSelectorWidgetAdapter(DigitalAvatarTemplateListSelectorWidget.b r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(d);
        this.a = r2;
        b r4 = new b();
        if (r3 == null) goto L6;
        r3.invoke(r4);
        this.b = new h(r4);
    L6:
        if (this.b == null) goto L8;
        int r5 = 1;
    L9:
        this.c = r5;
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof HeaderViewHolder) == false) goto L8;
        h r8 = this.b;
        if (r8 == null) goto L15;
        HeaderViewHolder r9 = (HeaderViewHolder) r6;
        Intrinsics.checkNotNullParameter(r9, "holder");
        r8.a.b.invoke(r9);
        return;
    L15:
        return;
    L8:
        if ((r6 instanceof DigitalAvatarSelectorHolder) == false) goto L17;
        final DigitalAvatarSelectorHolder r10 = (DigitalAvatarSelectorHolder) r6;
        final com.larus.bmhome.actionbar.model.f r11 = (com.larus.bmhome.actionbar.model.f) super.getItem(r7 - this.c);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "data");
        SimpleDraweeView r0 = r10.c;
        g1 r1 = r11.e;
        if (r1 == null) goto L12;
        String r2 = r1.b;
    L13:
        ImageLoaderKt.y(r0, r2, "custom_actionbar_icon_instruction", new c(r10), 4);
        r10.d.setText(r11.b);
        e1.d(r10.a, new com.larus.uaigc.avatar.instruction.a(r10, r11));
        e1.d(r10.e, new com.larus.uaigc.avatar.instruction.b(r10, r11));
        return;
    L12:
        r2 = null;
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L10;
        h r1 = this.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r0 = (View) r1.a.a.invoke(r3);
        if (r0 == null) goto L8;
    L25:
        return new HeaderViewHolder(r0);
    L8:
        r0 = new View(r3.getContext());
        goto L25
    L10:
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562484, r3, false);
        FrameLayout r6 = (FrameLayout) r5;
        int r2 = 2131375080;
        if (ViewBindings.findChildViewById(r5, 2131375080) == null) goto L24;
        r2 = 2131375083;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131375083)) == null) goto L24;
        r2 = 2131375084;
        if (ViewBindings.findChildViewById(r5, 2131375084) == null) goto L24;
        r2 = 2131384468;
        if (ViewBindings.findChildViewById(r5, 2131384468) == null) goto L24;
        FrameLayout r7 = (FrameLayout) r6.findViewById(2131367728);
        if (r7 == null) goto L22;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        r8.width = j19.c.c(100);
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        r9.height = j19.c.c(133);
    L22:
        return new DigitalAvatarSelectorHolder(r6, this.a);
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r2)));
    }
}
