package s2b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chatwindow.view.burn.CountDownView;
import com.ss.android.lark.team.TeamUtils;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d implements m2b.a {
    public final FragmentActivity a;
    public final u2b.d b;
    public final v c;
    public Chat d;
    public y6b.b e;
    public y6b.b f;
    public MultiSelector g;
    public OpenApp h;
    public String i;
    public lya.a j;
    public z2b.b k;
    public s4b.a<CountDownView> l;
    public int[] m;
    public ChatThemeInfo n;
    public long o;
    public Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> p;
    public final m2b.a q;
    public final Fragment r;
    public mya.h s;
    public o3b.a t;
    public boolean u;

    @Override // m2b.a
    public final boolean B8() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        y6b.b r1 = this.f;
        if (r1 == null) goto L13;
        y6b.b r2 = this.e;
        if (r2 == null) goto L13;
        if (r2.a.equals(r1.a) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        return r0.B8();
    }

    @Override // m2b.a
    public final String D8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.D8();
    L7:
        return this.i;
    }

    @Override // m2b.a
    public final MergeForwardContent F8() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.F8();
    }

    @Override // m2b.a
    public final o3b.a H8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.H8();
    L7:
        if (this.t != null) goto L10;
        this.t = new n3b.b(this);
    L10:
        return this.t;
    }

    @Override // r5b.a
    public boolean I() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.I();
    }

    @Override // m2b.a
    public final int[] J8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.J8();
    L7:
        return this.m;
    }

    @Override // m2b.a
    public final y6b.b K8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.K8();
    L7:
        return this.e;
    }

    @Override // m2b.a
    public final boolean L8() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.L8();
    }

    @Override // m2b.a
    public ThreadTopic N1() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.N1();
    }

    @Override // r5b.a
    public final boolean X() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        y6b.b r1 = this.f;
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.j != Chatter.ChatterType.BOT) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r2 = false;
        goto L12
    L5:
        return r0.X();
    }

    @Override // r5b.a
    public boolean Y() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.Y();
    }

    @Override // r5b.a
    public final boolean a() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        w4b.g r1 = ChatCoreModule.a().getChatDependency();
        getChat();
        return r1.a();
    L5:
        return r0.a();
    }

    @Override // r5b.a
    public boolean b0() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b0();
    }

    @Override // r5b.a
    public final boolean d() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.d();
    L7:
        if (getChat() != null) goto L11;
        return false;
    L11:
        return getChat().isP2PChat();
    }

    @Override // m2b.a
    public final OpenApp e() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.e();
    L7:
        return this.h;
    }

    @Override // r5b.a
    public boolean e0() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.e0();
    }

    @Override // m2b.a
    public Chat getChat() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.getChat();
    L7:
        return this.d;
    }

    @Override // r5b.a
    public final String getChatId() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.getChatId();
    L7:
        if (getChat() != null) goto L11;
        return BuildConfig.FLAVOR;
    L11:
        return getChat().getId();
    }

    @Override // m2b.a, r5b.a
    public FragmentActivity getContext() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.getContext();
    L7:
        return this.a;
    }

    @Override // r5b.a
    public final boolean h() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.h();
    L7:
        if (getChat() != null) goto L11;
        return false;
    L11:
        return getChat().isSuper();
    }

    @Override // m2b.a
    public final boolean isClickable() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isClickable();
    }

    @Override // m2b.a, r5b.a
    public final boolean isGroup() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.isGroup();
    L7:
        if (getChat() != null) goto L10;
        return false;
    L10:
        if (getChat().getType() != Chat.Type.GROUP) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // r5b.a
    public final boolean isMeeting() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.isMeeting();
    L7:
        if (getChat() != null) goto L11;
        return false;
    L11:
        return getChat().isMeeting();
    }

    @Override // m2b.a, r5b.a
    public final boolean isSecretChat() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.isSecretChat();
    L7:
        if (getChat() != null) goto L11;
        return false;
    L11:
        return getChat().isSecret();
    }

    @Override // r5b.a
    public final mya.h j5() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.j5();
    L7:
        return this.s;
    }

    @Override // r5b.a
    public final long k() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.k();
    L7:
        return this.o;
    }

    @Override // r5b.a
    public final lya.a l() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.l();
    L7:
        return this.j;
    }

    @Override // r5b.a
    public boolean m() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.m();
    }

    @Override // r5b.a
    public final boolean o() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        TeamUtils.b(getChat());
        return false;
    L5:
        return r0.o();
    }

    @Override // r5b.a
    public final boolean q() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.q();
    }

    @Override // m2b.a
    public final boolean q8() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.q8();
    }

    @Override // r5b.a
    public final boolean r() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.r();
    }

    @Override // m2b.a
    public final ChatThemeInfo r8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.r8();
    L7:
        return this.n;
    }

    @Override // m2b.a
    public final boolean s8() {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        MultiSelector r1 = this.g;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.d == false) goto L11;
        return true;
    L5:
        return r0.s8();
    }

    @Override // m2b.a
    public final y6b.b x8() {
        m2b.a r0 = this.q;
        if (r0 == null) goto L7;
        return r0.x8();
    L7:
        return this.f;
    }

    @Override // r5b.a
    public final boolean isAIChat() {
        Chat r0 = getChat();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isP2PChat() == false) goto L9;
        if (r0.isAIChat() == false) goto L9;
        return true;
    }

    @Override // m2b.a
    public final boolean A8() {
        return this.u;
    }

    @Override // m2b.a
    public final z2b.b I8() {
        return this.k;
    }

    @Override // r5b.a
    public final Fragment R() {
        return this.r;
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        return this.c;
    }

    @Override // m2b.a
    public final boolean E8(y6b.c r2) {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        MultiSelector r1 = this.g;
        if (r1 != null) goto L9;
    L12:
        return false;
    L9:
        if (r1.b.containsKey(Integer.valueOf(r2.hashCode())) == false) goto L12;
        return true;
    L5:
        return r0.E8(r2);
    }

    @Override // m2b.a
    public final void G8(CoreMessageListComponent.b r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.G8(r2);
        return;
    }

    @Override // r5b.a
    public final <T extends com.ss.android.lark.biz.im.api.message.params.l> T d0(Class<T> r3) {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> r1 = this.p;
        if (r1 != null) goto L9;
        return null;
    L9:
        T r4 = (T) ((HashMap) r1).get(r3);
        if (r4 != null) goto L12;
        return null;
    L12:
        return r4;
    L5:
        return (T) r0.d0(r3);
    }

    @Override // r5b.a
    public final void g(mya.i r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L5;
        r0.g(r2);
    L5:
        mya.h r1 = this.s;
        if (r1 == r2) goto L8;
        r2.e(r1);
    L8:
        this.s = r2;
    }

    @Override // r5b.a
    public final void h0(Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, ? extends com.ss.android.lark.biz.im.api.message.params.l> r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.h0(r2);
        return;
    L6:
        Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> r1 = this.p;
        if (r1 != null) goto L9;
        this.p = new HashMap(r2);
        return;
    L9:
        r1.putAll(r2);
    }

    @Override // r5b.a
    public final void j(long r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    L6:
        this.o = r2;
    }

    @Override // m2b.a
    public final void t8(o3b.a r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L5;
        r0.t8(r2);
    L5:
        this.t = r2;
    }

    @Override // r5b.a
    public final void u(CoreMessageListComponent.c r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.u(r2);
        return;
    L6:
        this.j = r2;
    }

    @Override // m2b.a
    public final void u8(MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L5;
        r0.u8(r2);
    L5:
        this.g = r2;
    }

    @Override // m2b.a
    public final void v8(int[] r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.v8(r2);
        return;
    L6:
        this.m = r2;
    }

    @Override // m2b.a
    public final void w8(int r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.w8(r2);
        return;
    }

    @Override // m2b.a
    public final boolean y8(y6b.c r2) {
        m2b.a r0 = this.q;
        if (r0 != null) goto L5;
        MultiSelector r1 = this.g;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.b(r2) == false) goto L11;
        return true;
    L5:
        return r0.y8(r2);
    }

    @Override // m2b.a
    public final void z8(String r2) {
        m2b.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.z8(r2);
        return;
    L6:
        this.i = r2;
    }

    public d(FragmentActivity r4, v r5, FrameFragment r6) {
        this.b = new u2b.d();
        this.i = BuildConfig.FLAVOR;
        this.j = null;
        this.k = null;
        this.o = -1132462081;
        this.p = null;
        new ConcurrentHashMap();
        this.q = null;
        this.s = new mya.i();
        this.t = null;
        this.u = false;
        this.a = r4;
        this.c = r5;
        this.r = r6;
    }

    public d(FragmentActivity r4, v r5, m2b.a r6, Fragment r7) {
        this.b = new u2b.d();
        this.i = BuildConfig.FLAVOR;
        this.j = null;
        this.k = null;
        this.o = -1132462081;
        this.p = null;
        new ConcurrentHashMap();
        this.q = null;
        this.s = new mya.i();
        this.t = null;
        this.u = false;
        this.a = r4;
        this.c = r5;
        this.q = r6;
        this.r = r7;
    }
}
