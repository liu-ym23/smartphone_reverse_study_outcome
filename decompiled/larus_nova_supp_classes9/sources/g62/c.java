package g62;

import com.bytedance.android.livesdk.interactivity.service.messagelist.l;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.service.messagelist.b {
    public final /* synthetic */ List a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.service.messagelist.a b;
    public final /* synthetic */ d c;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.service.messagelist.f d;
    public final /* synthetic */ l e;

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.b
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.a a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.b
    public final l b() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.b
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.f c() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.b
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.e d() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.b
    public final List<com.bytedance.android.livesdk.interactivity.service.messagelist.d> getInterceptors() {
        return this.a;
    }

    public c(List r1, b r2, d r3, e r4, l r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
