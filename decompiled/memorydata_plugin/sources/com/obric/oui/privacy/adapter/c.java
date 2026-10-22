package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.privacy.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "bind", "", "item", "Lcom/obric/oui/privacy/PrivacyItem$SwitchItem;", "position", "", "totalSwitchCount", "switchStartIndex", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OCardListItem f14390b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder$Companion;", "", "()V", "create", "Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final c a(Context r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.setDefaultCustomEndView(1);
            r6.e(true);
            r6.b(false);
            r6.g(false);
            return new c(r6);
        }
    }

    static {
        f14389a = new a(null);
    }

    public c(OCardListItem r3) {
        Intrinsics.checkNotNullParameter(r3, "cardListItem");
        super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        this.f14390b = r3;
    }

    private static final void a(d.b r0, CompoundButton r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "$item");
        Function1<Boolean, Unit> r3 = r0.d();
        if (r3 == null) goto L7;
        r3.invoke(Boolean.valueOf(r2));
        return;
    }

    public static /* synthetic */ void lambda$jPmb_jG9P0qp0cH17AMJakHpfB8(d.b r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    public final void a(final d.b r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "item");
        this.f14390b.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        int r2 = 1;
        if (r7.b() == null) goto L5;
        this.f14390b.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        this.f14390b.d(true);
    L6:
        int r11 = r8 - r10;
        if (r9 != 1) goto L9;
        r2 = 0;
    L15:
        OCardListItem.a(this.f14390b, r2, false, 2, null);
        OSwitch r6 = this.f14390b.getEndSwitch();
        if (r6 == null) goto L19;
        r6.setOnCheckedChangeListener(null);
    L19:
        if (r6 == null) goto L22;
        r6.setChecked(r7.c());
    L22:
        if (r6 == null) goto L26;
        r6.setOnCheckedChangeListener(new $$Lambda$c$jPmb_jG9P0qp0cH17AMJakHpfB8(r7));
        return;
    L26:
        return;
    L9:
        if (r11 == 0) goto L15;
        if (r11 != (r9 - 1)) goto L14;
        r2 = 3;
        goto L15
    L14:
        r2 = 2;
        goto L15
    L5:
        this.f14390b.d(false);
        goto L6
    }
}
