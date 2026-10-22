package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b implements k {
    public View a;
    public CompositeDisposable b;
    public t c;
    public v d;
    public final AudiencePanelItemSymbol e;

    public static final class a {
    }

    static {
    }

    public abstract int c();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void onDestroyView() {
        this.a = null;
        CompositeDisposable r1 = this.b;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.b = null;
    }

    public final boolean d() {
        t r0 = this.c;
        if ((r0 instanceof m4) == true) goto L5;
        r0 = null;
    L5:
        m4 r1 = (m4) r0;
        if (r1 == null) goto L8;
        IBaseUser r2 = r1.getUser();
    L9:
        if (r2 == null) goto L11;
        String r3 = r2.getUserId();
    L12:
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 2);
        if (r4 == null) goto L17;
        m r5 = r4.getUser();
        if (r5 == null) goto L17;
        User r6 = (User) r5.getValue();
    L18:
        if (r6 == null) goto L20;
        String r7 = r6.getUserId();
    L22:
        return StringsKt.equals$default(r7, r3, false, 2, null);
    L20:
        r7 = null;
    L17:
        r6 = null;
        goto L18
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final AudiencePanelItemSymbol a() {
        return this.e;
    }

    public b(AudiencePanelItemSymbol r2) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        this.e = r2;
        this.b = new CompositeDisposable();
    }

    public void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        View r0 = this.a;
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0.findViewById(2131375727);
        if (r1 == null) goto L9;
        r1.setText(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final View getView(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.a != null) goto L11;
        View r4 = LayoutInflater.from(r3).inflate(c(), null);
        this.a = r4;
        if (r4 == null) goto L11;
        r4.setTag(this.e);
    L11:
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void onClick(View r2) {
        if (this.e.getShowOutside() == false) goto L5;
        String r3 = "main";
    L6:
        e("default", r3, "default");
        return;
    L5:
        r3 = "secondary";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public void b(t r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        this.d = r3;
        f((String) ListProtector.get(this.e.getOutsideName(), 0));
    }

    public final void e(String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "functionStatus");
        Intrinsics.checkNotNullParameter(r14, "functionLevel");
        Intrinsics.checkNotNullParameter(r15, "functionValue");
        int r0 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.a;
        Map r1 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.a(this.c);
        t r2 = this.c;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L6;
        String r4 = String.valueOf(r2.getMessageId());
        if (r4 == null) goto L6;
    L7:
        String r5 = String.valueOf(this.e.getId());
        String r6 = String.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r4, "commentId");
        Intrinsics.checkNotNullParameter(r14, "function_level");
        Intrinsics.checkNotNullParameter(r5, "function_name");
        Intrinsics.checkNotNullParameter(r13, "function_status");
        Intrinsics.checkNotNullParameter(r15, "function_value");
        Intrinsics.checkNotNullParameter(r6, "event_time");
        Intrinsics.checkNotNullParameter(r1, "extra");
        HashMap r10 = new HashMap();
        r10.putAll(r1);
        r10.put("comment_id", r4);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.g.b() == false) goto L10;
        String r7 = "1";
    L11:
        r10.put("is_comment_connected", r7);
        r10.put("function_level", r14);
        r10.put("function_name", r5);
        r10.put("function_status", r13);
        r10.put("function_value", r15);
        r10.put("event_time", r6);
        IMiddlewareLiveService r16 = jc1.k.f(IMiddlewareLiveService.class);
        if (r16 == null) goto L19;
        ILiveOntologyInfoManager r17 = r16.getLiveOntologyRecord();
        if (r17 == null) goto L19;
        String r18 = r17.getEnterFromMerge();
        if (r18 == null) goto L19;
        r3 = r18;
    L19:
        r10.put("drawer_page", r3);
        j0.l().sendLog("livesdk_live_message_function_click", r10, new Object[]{new x(), IRoom.class});
        return;
    L10:
        r7 = "0";
    L6:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }
}
