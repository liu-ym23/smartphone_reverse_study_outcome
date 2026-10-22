package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/tab/TabSelectorView;", "Landroid/widget/LinearLayout;", "", "key", "", "setSelect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabSelectorView extends LinearLayout {
    public final TextView a;
    public final ImageView b;
    public boolean c;
    public n0 d;
    public xl4.a e;
    public a f;

    public interface a {
        void a(String r1);
    }

    public TabSelectorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TabSelectorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c() {
        this.c = false;
        this.b.setRotation(0.0f);
        xl4.a r0 = this.e;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.e = null;
    }

    private final void setSelect(String r2) {
        this.a.setText(r2);
        n0 r0 = this.d;
        if (r0 == null) goto L5;
        r0.a = r2;
    L5:
        a r1 = this.f;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }

    public static final /* synthetic */ void a(TabSelectorView r0, String r1) {
        r0.setSelect(r1);
    }

    public final void b(n0 r2, com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.b r3) {
        c();
        this.d = r2;
        this.f = r3;
        TextView r4 = this.a;
        if (r2 == null) goto L7;
        String r0 = r2.a;
        if (r0 == null) goto L7;
    L11:
        r4.setText(r0);
        setOnClickListener(new c(this));
        return;
    L7:
        if (r2 == null) goto L9;
        String r5 = r2.defaultKey;
    L10:
        r0 = r5;
        goto L11
    L9:
        r5 = null;
        goto L10
    }

    public TabSelectorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567486, this);
        this.a = (TextView) findViewById(2131391383);
        this.b = (ImageView) findViewById(2131376598);
    }

    public /* synthetic */ TabSelectorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
