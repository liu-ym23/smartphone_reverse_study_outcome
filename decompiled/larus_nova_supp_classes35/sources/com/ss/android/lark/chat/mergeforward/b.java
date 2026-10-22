package com.ss.android.lark.chat.mergeforward;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.im.base.page.BasePageFragment;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mya.h;
import mya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements m2b.a, com.ss.android.lark.chat.message.menu.context.c {
    public final FragmentActivity a;
    public final Chat b;
    public final String c;
    public final int d;
    public MultiSelector e;
    public long f;
    public final Fragment g;
    public h h;
    public lya.a i;
    public Map<Class<? extends l>, l> j;
    public o3b.a k;
    public final MergeForwardContent l;

    @Override // m2b.a
    public final /* synthetic */ boolean A8() {
        return false;
    }

    @Override // m2b.a
    public final boolean B8() {
        return false;
    }

    @Override // m2b.a
    public final String D8() {
        return BuildConfig.FLAVOR;
    }

    @Override // m2b.a
    public final /* synthetic */ void G8(CoreMessageListComponent.b r1) {
    }

    @Override // m2b.a
    public final /* synthetic */ z2b.b I8() {
        return null;
    }

    @Override // m2b.a
    public final int[] J8() {
        return null;
    }

    @Override // m2b.a
    public final y6b.b K8() {
        return null;
    }

    @Override // m2b.a
    public final /* synthetic */ boolean L8() {
        return false;
    }

    @Override // m2b.a
    public final ThreadTopic N1() {
        return null;
    }

    @Override // r5b.a
    public final boolean X() {
        return false;
    }

    @Override // r5b.a
    public final boolean Y() {
        return false;
    }

    @Override // r5b.a
    public final boolean a() {
        return false;
    }

    @Override // r5b.a
    public final boolean b0() {
        return false;
    }

    @Override // r5b.a
    public final boolean d() {
        return false;
    }

    @Override // m2b.a
    public final OpenApp e() {
        return null;
    }

    @Override // r5b.a
    public final boolean e0() {
        return true;
    }

    @Override // r5b.a
    public final String getChatId() {
        return BuildConfig.FLAVOR;
    }

    @Override // r5b.a
    public final boolean h() {
        return false;
    }

    @Override // r5b.a
    public final boolean isAIChat() {
        return false;
    }

    @Override // m2b.a
    public final /* synthetic */ boolean isClickable() {
        return true;
    }

    @Override // m2b.a, r5b.a
    public final boolean isGroup() {
        return false;
    }

    @Override // r5b.a
    public final boolean isMeeting() {
        return false;
    }

    @Override // m2b.a, r5b.a
    public final boolean isSecretChat() {
        return false;
    }

    @Override // r5b.a
    public final boolean m() {
        return false;
    }

    @Override // r5b.a
    public final boolean o() {
        return false;
    }

    @Override // r5b.a
    public final boolean q() {
        return false;
    }

    @Override // m2b.a
    public final boolean q8() {
        return false;
    }

    @Override // r5b.a
    public final boolean r() {
        return false;
    }

    @Override // m2b.a
    public final /* synthetic */ ChatThemeInfo r8() {
        return null;
    }

    @Override // m2b.a
    public final void v8(int[] r1) {
    }

    @Override // m2b.a
    public final void w8(int r1) {
    }

    @Override // m2b.a
    public final y6b.b x8() {
        return null;
    }

    @Override // m2b.a
    public final void z8(String r1) {
    }

    @Override // m2b.a
    public final o3b.a H8() {
        if (this.k != null) goto L6;
        this.k = new n3b.b(this);
    L6:
        return this.k;
    }

    @Override // r5b.a
    public final boolean I() {
        if (this.d != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // m2b.a
    public final boolean s8() {
        MultiSelector r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d == false) goto L7;
        return true;
    }

    @Override // m2b.a
    public final MergeForwardContent F8() {
        return this.l;
    }

    @Override // r5b.a
    public final Fragment R() {
        return this.g;
    }

    @Override // com.ss.android.lark.chat.message.menu.context.c
    public final int U() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.message.menu.context.c
    public final String g0() {
        return this.c;
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        return ChatAppContainerV1.a;
    }

    @Override // m2b.a
    public final Chat getChat() {
        return this.b;
    }

    @Override // m2b.a, r5b.a
    public FragmentActivity getContext() {
        return this.a;
    }

    @Override // r5b.a
    public final h j5() {
        return this.h;
    }

    @Override // r5b.a
    public final long k() {
        return this.f;
    }

    @Override // r5b.a
    public final lya.a l() {
        return this.i;
    }

    @Override // m2b.a
    public final boolean E8(y6b.c r2) {
        MultiSelector r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b.containsKey(Integer.valueOf(r2.hashCode())) == false) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.message.menu.context.c
    public final Message b(String r4) {
        MergeForwardContent r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getMessages() == null) goto L18;
        Iterator<Message> r1 = this.l.getMessages().iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        Message r2 = r1.next();
        if (TextUtils.equals(r4, r2.getId()) == false) goto L9;
        return r2;
    L19:
        return null;
    L18:
        return null;
    }

    @Override // r5b.a
    public final <T extends l> T d0(Class<T> r3) {
        Map<Class<? extends l>, l> r0 = this.j;
        if (r0 != null) goto L5;
        return null;
    L5:
        T r4 = (T) ((HashMap) r0).get(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4;
    }

    @Override // r5b.a
    public final void g(i r2) {
        h r0 = this.h;
        if (r0 == r2) goto L5;
        r2.e(r0);
    L5:
        this.h = r2;
    }

    @Override // r5b.a
    public final void h0(Map<Class<? extends l>, ? extends l> r2) {
        Map<Class<? extends l>, l> r0 = this.j;
        if (r0 != null) goto L5;
        this.j = new HashMap(r2);
        return;
    L5:
        r0.putAll(r2);
    }

    @Override // r5b.a
    public final void j(long r1) {
        this.f = r1;
    }

    @Override // m2b.a
    public final void t8(o3b.a r1) {
        this.k = r1;
    }

    @Override // r5b.a
    public final void u(CoreMessageListComponent.c r1) {
        this.i = r1;
    }

    @Override // m2b.a
    public final void u8(MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r1) {
        this.e = r1;
    }

    @Override // m2b.a
    public final boolean y8(y6b.c r2) {
        MultiSelector r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b(r2) == false) goto L7;
        return true;
    }

    public b(FragmentActivity r3, MergeForwardContent r4, int r5, BasePageFragment r6) {
        this.f = -1132462081;
        this.h = new i();
        this.i = null;
        new ConcurrentHashMap();
        this.j = null;
        this.k = new n3b.b(this);
        this.l = null;
        this.a = r3;
        this.b = r4.getOriginChat();
        this.d = r5;
        this.c = r4.getMessageId();
        this.g = r6;
        this.l = r4;
    }
}
