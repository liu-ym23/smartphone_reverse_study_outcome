package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.m61;
import com.bytedance.android.livesdk.config.te0;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/GameIntroCard;", "Lcom/bytedance/android/livesdk/widget/roundcorner/RoundCornerFrameLayout;", "Lcom/bytedance/android/live/broadcastgame/openplatform/miniapp/card/a;", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/a;", "", "color", "", "setGradientBackground", "info", "setData", "", "getType", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getOnClickBlock", "()Lkotlin/jvm/functions/Function0;", "setOnClickBlock", "(Lkotlin/jvm/functions/Function0;)V", "onClickBlock", "d", "getOnCloseBlock", "setOnCloseBlock", "onCloseBlock", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameIntroCard extends RoundCornerFrameLayout implements com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a<com.bytedance.android.live.broadcastgame.api.openplatform.a> {
    public Map<Integer, View> b;
    public Function0<Unit> c;
    public Function0<Unit> d;

    public static final class a implements Runnable {
        public final /* synthetic */ GameIntroCard a;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.a b;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.GameIntroCard$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0056a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0056a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                Function0<Unit> r2 = this.a.a.getOnCloseBlock();
                if (r2 == null) goto L6;
                Unit r3 = (Unit) r2.invoke();
                return;
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                Function0<Unit> r2 = this.a.a.getOnClickBlock();
                if (r2 == null) goto L6;
                Unit r3 = (Unit) r2.invoke();
                return;
            }
        }

        public a(GameIntroCard r1, com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            boolean r1 = false;
            if (((m61) te0.a.getValue()).c() != 1) goto L5;
            boolean r0 = true;
        L6:
            String r3 = this.b.c;
            if (r3 != null) goto L9;
        L12:
            boolean r4 = true;
        L14:
            if (r4 == true) goto L18;
            if (r0 == true) goto L18;
            LayoutInflater.from(this.a.getContext()).inflate(2131567062, this.a);
            float r2 = 4;
            com.bytedance.android.live.broadcastgame.opengame.utils.i.a(this.a.a(2131389496), this.b.c, new PointF(0.0f, 0.0f), UtilityKotlinExtentionsKt.h(r2), UtilityKotlinExtentionsKt.h(r2), 0.0f, 0.0f, 98);
        L28:
            ((TextView) this.a.a(2131389518)).setText(this.b.f);
            ((TextView) this.a.a(2131389495)).setText(this.b.g);
            ((ImageView) this.a.a(2131376107)).setOnClickListener(new ViewOnClickListenerC0056a(this));
            this.a.setOnClickListener(new b(this));
            return;
        L18:
            LayoutInflater.from(this.a.getContext()).inflate(2131567063, this.a);
            float r5 = 8;
            com.bytedance.android.live.broadcastgame.opengame.utils.i.a(this.a.a(2131389496), this.b.b, new PointF(0.0f, 0.0f), UtilityKotlinExtentionsKt.h(r5), UtilityKotlinExtentionsKt.h(r5), UtilityKotlinExtentionsKt.h(r5), UtilityKotlinExtentionsKt.h(r5), 2);
            String r6 = this.b.e;
            if (r6 != null) goto L21;
        L22:
            r1 = true;
        L24:
            if (r1 == false) goto L26;
            ((TextView) this.a.a(2131389456)).setText(this.b.d);
        L27:
            GameIntroCard.b(this.a, this.b.h);
            goto L28
        L26:
            ((TextView) this.a.a(2131389456)).setText(this.b.e);
            goto L27
        L21:
            if (r6.length() != 0) goto L24;
        L9:
            if (r3.length() == 0) goto L12;
            r4 = false;
            goto L14
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public GameIntroCard(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GameIntroCard(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public int getType() {
        return 99;
    }

    public Function0<Unit> getOnClickBlock() {
        return this.c;
    }

    public Function0<Unit> getOnCloseBlock() {
        return this.d;
    }

    private final void setGradientBackground(String r4) {
        int[] r0 = new int[2];
        r0[1] = 0;
        r0[0] = Color.parseColor(r4);     // Catch: Exception -> L5
    L6:
        GradientDrawable r5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, r0);
        r5.setCornerRadius(s1.f(5.0f));
        r5.setGradientType(0);
        a(2131373427).setBackground(r5);
        a(2131373427).setVisibility(0);
        return;
    L5:
        r0[0] = ColorProtector.parseColor("#3D05A8F4");
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(int r3) {
        if (this.b != null) goto L5;
        this.b = new LinkedHashMap();
    L5:
        View r0 = this.b.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.b.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: setData, reason: avoid collision after fix types in other method */
    public void setData2(com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        post(new a(this, r2));
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public void setOnClickBlock(Function0<Unit> r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public void setOnCloseBlock(Function0<Unit> r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.a
    public /* bridge */ /* synthetic */ void setData(com.bytedance.android.live.broadcastgame.api.openplatform.a r1) {
        setData2(r1);
    }

    public static final /* synthetic */ void b(GameIntroCard r0, String r1) {
        r0.setGradientBackground(r1);
    }

    public GameIntroCard(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new LinkedHashMap();
        J(UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5));
    }

    public /* synthetic */ GameIntroCard(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
