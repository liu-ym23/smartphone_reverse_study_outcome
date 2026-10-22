package s62;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.k;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qb2.g;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements l, k22.b {
    public CompositeDisposable a;
    public boolean b;
    public boolean c;
    public yo2.e d;
    public List<AICloneConvItem> e;
    public d f;
    public Context g;
    public IRoom h;
    public View i;
    public final DataContext j;
    public final DataCenter k;

    /* JADX INFO: renamed from: s62.a$a, reason: collision with other inner class name */
    public static final class C0275a {
    }

    static {
    }

    @Override // k22.b
    public final AICloneConvItem a() {
        List<AICloneConvItem> r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (AICloneConvItem) CollectionsKt.firstOrNull(r0);
    }

    @Override // k22.b
    public final void c() {
        ALogger.i("AICloneTag", "unload manager,timestamp = " + System.currentTimeMillis());
        DataCenter r0 = this.k;
        if (r0 == null) goto L5;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager");
    L6:
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        d r2 = this.f;
        if (r2 == null) goto L11;
        hd0.c.f().e(r2);
    L11:
        this.b = false;
        this.c = false;
        CompositeDisposable r3 = this.a;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        yo2.e r4 = this.d;
        if (r4 == null) goto L17;
        r4.d();
    L17:
        this.d = null;
        this.a = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean d() {
        ALogger.i("AICloneTag", "link state = " + ((Integer) ((ge1.a) hd0.c.f()).b));
        Boolean r0 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a(this.h) == true) goto L5;
    L17:
        return false;
    L5:
        if (a() == null) goto L17;
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L10;
    L11:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L15;
        return true;
    L15:
        if (2 == r2.intValue()) goto L17;
        return true;
    L10:
        if (1 == r1.intValue()) goto L17;
        goto L11
    }

    public static String f(String r3) {
        String r0 = BuildConfig.FLAVOR;
        if (r3 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        JSONObject r4 = s2.a(Uri.decode(r3));
        o r1 = j0.l().c(x.class);
        if (r1 == null) goto L13;
        Map r2 = r1.getMap();
        if (r2 == null) goto L13;
        String r5 = (String) r2.get("enter_method");
        if (r5 == null) goto L13;
        r0 = r5;
    L13:
        r4.put("live_enter_method", r0);
        return r4.toString();
    }

    public final void e(int r3) {
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.b.a(InteractivityMonitor.Event.AIBootMessageShowFailed, this.h, Integer.valueOf(r3));
    }

    public final void onMessage(tlc.d r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8 instanceof k) == false) goto L36;
        k r9 = (k) r8;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.b.b(InteractivityMonitor.Event.AIBootMessageReceive, this.h);
        if (d() == true) goto L9;
        ALogger.i("AICloneTag", "receive one boot message but can't show");
        e(1);
        return;
    L9:
        if (this.b == true) goto L11;
        e(2);
        ALogger.i("AICloneTag", "comment ai icon invisiable, can't show");
        return;
    L11:
        yo2.e r0 = this.d;
        if (r0 == null) goto L17;
        if (r0.h() != true) goto L17;
        e(3);
        ALogger.i("AICloneTag", "a bubble is showing, can't show");
        return;
    L17:
        if (this.i != null) goto L20;
        e(4);
        ALogger.i("AICloneTag", "ai view is null can't show");
        return;
    L20:
        if (this.c == false) goto L22;
        e(5);
        ALogger.i("AICloneTag", "in clear screen, can't show");
        return;
    L22:
        View r1 = LayoutInflater.from(this.g).inflate(2131565316, null);
        TransparentCircleIconView r2 = r1.findViewById(2131364887);
        m0 r3 = r9.getCommon();
        if (r3 == null) goto L29;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L29;
        py.k r5 = r4.getAvatarThumbKt();
        if (r5 == null) goto L29;
        ImageLoader.bindImage(r2, r5);
    L29:
        r1.setOnClickListener(new f(this, r9));
        TextView r6 = (TextView) r1.findViewById(2131390250);
        m0 r10 = r9.getCommon();
        if (r10 == null) goto L42;
        a5 r11 = r10.getDisplayText();
        if (r11 == null) goto L43;
        LiveRichContentEngine.a().a().c(mb2.d.a(r11, null, 1.0f), new g(false, 0.0f, 7), new e(this, r6, r1));
        return;
    L43:
        return;
    L42:
        return;
    }

    public a(DataContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "dataContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.j = r2;
        this.k = r3;
    }

    @Override // k22.b
    public final void b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "actionType");
        if (r8 != null) goto L5;
    L38:
        List<AICloneConvItem> r10 = this.e;
        if (r10 == null) goto L52;
        AICloneConvItem r11 = (AICloneConvItem) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L53;
        f2.c(r11.getErrToast(), 0);
        return;
    L53:
        return;
    L52:
        return;
    L5:
        if (d() == false) goto L38;
        ALogger.i("AICloneTag", "open schema, origin schema is ".concat(r8));
        Uri.Builder r1 = UriProtector.parse(r8).buildUpon();
        o r4 = j0.l().c(x.class);     // Catch: Throwable -> L27 Exception -> L29
        if (r4 == null) goto L14;
        Map r5 = r4.getMap();     // Catch: Throwable -> L27 Exception -> L29
        if (r5 == null) goto L14;
        String r6 = (String) r5.get("enter_from_merge");     // Catch: Throwable -> L27 Exception -> L29
        if (r6 == null) goto L14;
    L15:
        r1.appendQueryParameter("enter_from", r6).appendQueryParameter("enter_method", r9);     // Catch: Throwable -> L27 Exception -> L29
        Uri r13 = r1.build();     // Catch: Throwable -> L27 Exception -> L29
        Set<String> r3 = r13.getQueryParameterNames();     // Catch: Throwable -> L27 Exception -> L29
        Uri.Builder r7 = r13.buildUpon().clearQuery();     // Catch: Throwable -> L27 Exception -> L29
        Iterator<String> r14 = r3.iterator();     // Catch: Throwable -> L27 Exception -> L29
    L16:
        if (r14.hasNext() == false) goto L24;
        String r15 = r14.next();     // Catch: Throwable -> L27 Exception -> L29
        if (Intrinsics.areEqual(r15, "log_extra") == false) goto L21;
        String r16 = f(r13.getQueryParameter(r15));     // Catch: Throwable -> L27 Exception -> L29
    L22:
        r7.appendQueryParameter(r15, r16);     // Catch: Throwable -> L27 Exception -> L29
        goto L16
    L21:
        r16 = r13.getQueryParameter(r15);     // Catch: Throwable -> L27 Exception -> L29
        goto L22
    L24:
        String r17 = r7.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r17);
        Context r18 = this.g;
        if (r18 == null) goto L49;
    L33:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r18, r17);
        return;
    L49:
        return;
    L14:
        r6 = BuildConfig.FLAVOR;
    L27:
        th = move-exception;
        String r19 = r1.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r19);
        Context r0 = this.g;
        if (r0 == null) goto L37;
        jc1.k.n(IBaseLiveActionHandler.class).handle(r0, r19);
    L37:
        throw th;
    L29:
        e = move-exception;
        SafetyGuard.a(null, e, "origin schema is " + r8);     // Catch: Throwable -> L27
        r17 = r1.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r17);
        r18 = this.g;
        if (r18 != null) goto L33;
    }
}
