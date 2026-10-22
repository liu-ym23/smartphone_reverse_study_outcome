package com.larus.community.impl.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.databinding.LarusCommunityCreateButtonBinding;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r29.b;
import r29.d;
import r29.e;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u001a\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\f\u0010\u001f\u001a\u00020\u0016*\u00020\u001cH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/community/impl/view/CommunityCreateButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreateButtonBinding;", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "totalY", "", "value", "", "isShow", "()Z", "setShow", "(Z)V", "show", "", "hide", "renderGradientStyle", "gradientTextTask", "zoomOutAnimation", "view", "Landroid/view/View;", "scaleSize", "zoomInAnimation", "bounceWhenPressedItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityCreateButton extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusCommunityCreateButtonBinding a;
    public AnimatorSet b;
    public AnimatorSet c;
    public final float d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        TextView r0 = this.a.b;
        r0.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r0.getWidth(), r0.getHeight(), new int[]{ColorProtector.parseColor("#FF9851"), ColorProtector.parseColor("#FF6C55"), ColorProtector.parseColor("#BC72FF"), ColorProtector.parseColor("#5083E5")}, null, Shader.TileMode.CLAMP));
        FLogger.a.i("CommunityCreateButton", "width:" + r0.getWidth() + ", height:" + r0.getHeight());
        setAlpha(1.0f);
        r0.setAlpha(1.0f);
        r0.invalidate();
    }

    public final void b() {
        TextView r0 = this.a.b;
        if (r0.getWidth() != 0) goto L5;
    L8:
        r0.post(new r29.a(this));
        return;
    L5:
        if (r0.getHeight() == 0) goto L8;
        a();
    }

    public CommunityCreateButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setShow(boolean r14) {
        if (r14 != this.e) goto L5;
        return;
    L5:
        this.e = r14;
        if (r14 == false) goto L16;
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        r9.put("current_page", "ai_generate");     // Catch: JSONException -> L10
    L12:
        TrackParams r15 = new TrackParams().merge(r9);
        by7.a r10 = new by7.a("show_create_button");
        r10.a.merge(r15);
        r10.b();
        AnimatorSet r16 = this.c;
        if (r16 == null) goto L15;
        r16.cancel();
    L15:
        this.c = null;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(this, "translationY", new float[]{this.d, 0.0f});
        r17.setInterpolator(new CubicBezierInterpolator(0.38f, 1.35f, 0.8f));
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.play(r17).with(r2);
        r3.setDuration((long) ((1 - getAlpha()) * 300));
        r3.addListener(new e(this));
        r3.start();
        this.b = r3;
        return;
    L10:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobShowCreateButton " + e.getLocalizedMessage());
        goto L12
    L16:
        AnimatorSet r18 = this.b;
        if (r18 == null) goto L19;
        r18.cancel();
    L19:
        this.b = null;
        ObjectAnimator r110 = ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, this.d});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        AnimatorSet r5 = new AnimatorSet();
        r5.play(r110).with(r4);
        r5.setDuration((long) (getAlpha() * 300));
        r5.addListener(new d(this));
        r5.start();
        this.c = r5;
    }

    public CommunityCreateButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131561922, this);
        int r4 = 2131367586;
        if (((RoundLinearLayout) ViewBindings.findChildViewById(this, 2131367586)) == null) goto L9;
        r4 = 2131367587;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131367587);
        if (r5 == null) goto L9;
        LarusCommunityCreateButtonBinding r6 = new LarusCommunityCreateButtonBinding(this, r5);
        setOnTouchListener(new b(this, this));
        this.a = r6;
        this.d = i5.u0();
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r4)));
    }
}
