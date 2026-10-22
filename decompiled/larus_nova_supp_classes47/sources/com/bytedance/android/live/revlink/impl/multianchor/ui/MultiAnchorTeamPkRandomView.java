package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.utils.x0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorTeamPkRandomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lq21/k;", "item", "", "update", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "getMatchService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "matchService", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchContext;", "getMatchContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchContext;", "matchContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/c;", "getMatchStatus", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/c;", "matchStatus", "Lcom/bytedance/android/livesdk/link/model/b0;", "getSelfAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/b0;", "selfAutoMatchInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkRandomView extends ConstraintLayout {
    public Map<Integer, View> a;
    public final View b;

    public MultiAnchorTeamPkRandomView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MultiAnchorTeamPkRandomView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final MultiPkMatchContext getMatchContext() {
        return com.bytedance.android.live.revlink.impl.global.b.G();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.match.a getMatchService() {
        return com.bytedance.android.live.revlink.impl.global.b.I();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.match.c getMatchStatus() {
        MultiPkMatchContext r0 = getMatchContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.match.c) r1.getValue();
    L7:
        return null;
    }

    private final b0 getSelfAutoMatchInfo() {
        MultiPkMatchContext r0 = getMatchContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getSelfAutoMatchInfo();
        if (r1 == null) goto L7;
        return (b0) r1.getValue();
    L7:
        return null;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.match.a R5(MultiAnchorTeamPkRandomView r0) {
        return r0.getMatchService();
    }

    public static final /* synthetic */ b0 S5(MultiAnchorTeamPkRandomView r0) {
        return r0.getSelfAutoMatchInfo();
    }

    public static final boolean T5(MultiAnchorTeamPkRandomView r0) {
        com.bytedance.android.live.revlink.impl.multianchor.match.c r1 = r0.getMatchStatus();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(final q21.k r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        boolean r2 = true;
        ((TextView) _$_findCachedViewById(2131391238)).getPaint().setFakeBoldText(true);
        b0 r1 = r9.a;
        String r3 = r1.getMainTitle();
        if (r3 == null) goto L5;
        ((TextView) _$_findCachedViewById(2131391238)).setText(r3);
    L5:
        String r0 = r1.getSubTitle();
        if (r0 == null) goto L8;
        ((TextView) _$_findCachedViewById(2131391524)).setText(r0);
    L8:
        Long r4 = Long.valueOf(r1.getWaitSec());
        if (r4.longValue() > 0) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L24;
        long r5 = r4.longValue();
        if (r5 < 60) goto L23;
        int r6 = (int) r5;
        int r7 = r6 / 60;
        if ((r6 % 60) == 0) goto L22;
        r7 = r7 + 1;
    L22:
        ((TextView) _$_findCachedViewById(2131391709)).setText(String.valueOf(r7));
        ((TextView) _$_findCachedViewById(2131391708)).setText(s1.B(2131919650));
        goto L24
    L23:
        ((TextView) _$_findCachedViewById(2131391709)).setText(String.valueOf(r5));
        ((TextView) _$_findCachedViewById(2131391708)).setText(s1.B(2131919652));
    L24:
        ((TextView) _$_findCachedViewById(2131391709)).setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
        ((TextView) _$_findCachedViewById(2131391428)).setOnClickListener(x0.a(new AnonymousClass5(this, r9)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiAnchorTeamPkRandomView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = LayoutInflater.from(r2).inflate(2131566335, this);
    }

    public /* synthetic */ MultiAnchorTeamPkRandomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
