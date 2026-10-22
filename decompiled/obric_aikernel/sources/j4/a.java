package j4;

import f4.h;

/* JADX INFO: loaded from: classes.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f9760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.news.common.settings.internal.a f9761b;

    public a(String r10, h r11) {
        this.f9760a = r11;
        this.f9761b = com.bytedance.news.common.settings.internal.a.a();
    }

    @Override // f4.h
    public String a(String r10) {
        return getString(r10, "");
    }

    @Override // f4.h
    public void apply() {
        this.f9760a.apply();
    }

    @Override // f4.h
    public boolean contains(String r10) {
        return this.f9760a.contains(r10);
    }

    @Override // f4.h
    public String getString(String r10, String r11) {
        String r12 = this.f9760a.getString(r10, r11);
        this.f9761b.b(r10, r12);
        return r12;
    }

    @Override // f4.h
    public void putString(String r10, String r11) {
        this.f9760a.putString(r10, r11);
        this.f9761b.b(r10, r11);
    }
}
