package m22;

import android.view.View;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mx.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends g {
    public final Function2<a, Boolean, Unit> q;
    public final Function0<Unit> r;

    /* JADX INFO: renamed from: m22.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0246a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0246a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.r.invoke();
        }
    }

    public final View.OnClickListener f() {
        return new ViewOnClickListenerC0246a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function2<? super a, ? super Boolean, Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "onChanged");
        Intrinsics.checkNotNullParameter(r6, "onHelpIconClick");
        super("口播转评论", ((com.bytedance.android.livesdk.chatroom.model.b) e.b.getValue()).status, null, 60);
        this.q = r5;
        this.r = r6;
    }

    public final void c(SwitchSettingViewHolder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.c(r2, r3);
        this.q.invoke(this, Boolean.valueOf(r3));
    }
}
