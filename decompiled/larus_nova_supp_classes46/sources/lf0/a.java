package lf0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ InteractAudienceAlertWindow a;
    public final /* synthetic */ IBaseUser b;

    /* JADX INFO: renamed from: lf0.a$a, reason: collision with other inner class name */
    public static final class C0230a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0230a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (this.a.b == null) goto L8;
            com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.d r4 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
            if (r4 == null) goto L9;
            r4.g0(this.a.b);
            return;
        L9:
            return;
        }
    }

    public a(InteractAudienceAlertWindow r1, IBaseUser r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        if (k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() != 0) goto L5;
    L8:
        Disposable r1 = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0230a(this));
        this.a.getCompositeDisposable().add(r1);
        this.a.setLoading(true);
        TalkRoomLogUtils r6 = TalkRoomLogUtils.B;
        IBaseUser r2 = this.b;
        if (r2 == null) goto L12;
        String r3 = r2.getIdString();
        if (r3 == null) goto L12;
    L13:
        String r7 = r3;
        IBaseUser r4 = this.b;
        if (r4 == null) goto L16;
        boolean r16 = r4.isSubscriber();
    L17:
        TalkRoomLogUtils.s0(r6, r7, "anchor", null, "seat", false, null, null, null, null, r16, null, null, 3568);
        ((TextView) this.a.a(2131361963)).setVisibility(4);
        ((LinearLayout) this.a.a(2131378977)).setVisibility(0);
        ((ImageView) this.a.a(2131366972)).setVisibility(4);
        InteractAudienceAlertWindow r5 = this.a;
        View.OnClickListener r8 = r5.g;
        if (r8 == null) goto L21;
        r8.onClick(r5);
        return;
    L21:
        return;
    L16:
        r16 = false;
    L12:
        r3 = "";
        goto L13
    L5:
        if (us1.b.a() == true) goto L8;
        f2.b(2131917544, 0);
    }
}
