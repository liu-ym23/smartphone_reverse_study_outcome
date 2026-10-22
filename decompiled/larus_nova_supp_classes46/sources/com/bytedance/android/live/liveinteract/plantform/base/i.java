package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface i<T extends h> {

    public static class a<T extends h> implements b<T> {
        public a() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void a(String r1, String r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void b(String r1, String r2, boolean r3) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<T> r1, List<T> r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void e(List<LinkmicPositionItem> r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void g(String r1, long r2, String r4, l r5) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void k() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<T> r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<T> r1, long r2, n0 r4) {
        }
    }

    public interface b<T extends h> {
        void a(String r1, String r2);

        void b(String r1, String r2, boolean r3);

        void d(List<T> r1, List<T> r2);

        void e(List<LinkmicPositionItem> r1);

        void g(String r1, long r2, String r4, l r5);

        void k();

        void l(List<T> r1);

        void n(List<T> r1, long r2, n0 r4);

        void onOnlineListChanged(List<T> r1);
    }

    public interface c {
        void a(n0 r1);
    }

    public static class d implements b<ILinkPlayerInfoBridge> {
        public d() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void a(String r1, String r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void b(String r1, String r2, boolean r3) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void d(List<ILinkPlayerInfoBridge> r1, List<ILinkPlayerInfoBridge> r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void e(List<LinkmicPositionItem> r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void g(String r1, long r2, String r4, l r5) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void k() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void l(List<ILinkPlayerInfoBridge> r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void n(List<ILinkPlayerInfoBridge> r1, long r2, n0 r4) {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public void onOnlineListChanged(List<ILinkPlayerInfoBridge> r1) {
        }
    }

    String N4(String r1);

    int O4(String r1);

    int P4(int r1);

    void Q4(b<T> r1);

    void R4(boolean r1);

    void S4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1, ClientUIInfo r2, long r3, String r5);

    void T4(b<T> r1);

    IBaseUser U4(String r1);

    List<T> V4();

    void W4();

    void X4();

    void Y4(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1, ClientUIInfo r2, long r3, String r5, Map<Long, ? extends g2> r6);

    Boolean Z4();

    List<T> a();

    T a5(String r1, String r2);

    int b();

    boolean b5(String r1);

    List<T> c();

    IBaseUser c5(String r1);

    List<LinkmicPositionItem> d();

    T getGuestInfo(String r1, String r2);

    long getLastVersion();

    List<T> getOnlineUserList();

    void r0();

    void v();
}
