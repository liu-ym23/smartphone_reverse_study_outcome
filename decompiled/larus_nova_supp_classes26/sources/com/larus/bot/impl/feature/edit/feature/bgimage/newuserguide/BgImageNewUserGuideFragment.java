package com.larus.bot.impl.feature.edit.feature.bgimage.newuserguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.common.util.h;
import com.larus.bot.impl.databinding.LarusPageBgImageNewUserGuideBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import zu8.b;
import zu8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000fJ\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/newuserguide/BgImageNewUserGuideFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBgImageNewUserGuideBinding;", "autoLogEnterPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "onResult", "bundle", "initView", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImageNewUserGuideFragment extends TraceFragment {
    public static final /* synthetic */ int f = 0;
    public LarusPageBgImageNewUserGuideBinding e;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public BgImageNewUserGuideFragment() {
    }

    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r19);
        LarusPageBgImageNewUserGuideBinding r0 = this.e;
        if (r0 == null) goto L5;
        NovaTitleBarEx.b6(r0.e, 2131243589, false, null, null, new zu8.a(this), 14);
        h.b(r0.c, UriProtector.parse(r0.a.getContext().getString(2131900192)), "bg_image_new_user_guide", false, Integer.valueOf(c7.b(262)), Integer.valueOf(c7.b(467)), null, 96);
        e1.d(r0.b, new b(this));
        e1.d(r0.d, new c(this));
        Unit r1 = Unit.INSTANCE;
    L5:
        tu8.a.a.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        tu8.a.b.storeBoolean("has_entered_bg_image_new_user_guide", true);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.put("edit_way", "new_guidance_to_edit_notification");     // Catch: JSONException -> L13
    L15:
        TrackParams r4 = new TrackParams().merge(r3);
        by7.a r5 = new by7.a("create_bot_guidance_show");
        r5.a.merge(r4);
        r5.b();
        return;
    L13:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_guidance_show " + e.getLocalizedMessage());
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562996, r8, false);
        int r11 = 2131362399;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131362399)) == null) goto L19;
        r11 = 2131362400;
        View r2 = ViewBindings.findChildViewById(r10, 2131362400);
        if (r2 == null) goto L19;
        r11 = 2131374931;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r10, 2131374931);
        if (r3 == null) goto L19;
        r11 = 2131385776;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131385776);
        if (r4 == null) goto L19;
        r11 = 2131387625;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131387625)) == null) goto L19;
        r11 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131388772)) == null) goto L19;
        r11 = 2131389234;
        NovaTitleBarEx r5 = (NovaTitleBarEx) ViewBindings.findChildViewById(r10, 2131389234);
        if (r5 == null) goto L19;
        ConstraintLayout r12 = r10;
        this.e = new LarusPageBgImageNewUserGuideBinding(r12, r2, r3, r4, r5);
        return r12;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
