package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements c0.a {
    public final a2b.n a;
    public final a2b.o b;
    public final WeakReference<b> c;
    public final c d;

    public static final class a {
    }

    public interface b {
        void onPushUserGroup(Map<Long, UserGroupEntity> r1);
    }

    public static final class c implements com.ss.android.lark.biz.im.api.usergroup.a {
        public final /* synthetic */ s a;

        public c(s r1) {
            this.a = r1;
        }

        public final void a(Map<Long, UserGroupEntity> r2) {
            Intrinsics.checkNotNullParameter(r2, "userGroups");
            b r0 = this.a.c.get();
            if (r0 == null) goto L6;
            r0.onPushUserGroup(r2);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.b.w9(this.d);
        this.a.C3(this.d);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.b.z1(this.d);
        this.a.vc(this.d);
    }

    public s(a2b.n r2, a2b.o r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "userGroupPush");
        Intrinsics.checkNotNullParameter(r3, "userGroupService");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r2;
        this.b = r3;
        this.c = new WeakReference(r4);
        this.d = new c(this);
    }
}
