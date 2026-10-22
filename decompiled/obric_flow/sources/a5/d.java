package a5;

import ai.p;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.a f107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f108c;
    public int d;
    public long e;
    public HashMap f;
    public HashSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CheckFilter f109h;

    public d() {
        this.f106a = new p(1);
        this.f107b = new f9.a(1);
        this.f = new HashMap();
        this.g = new HashSet();
        this.f109h = new CheckFilter();
    }

    public final String toString() {
        return "HybridSettingResponse{bidInfo=" + this.f106a + ", switchConfig=" + this.f107b + ", updateTime='" + this.f108c + "', duration=" + this.d + ", settingId=" + this.e + "', allEventSample=" + this.f + ", hostWhiteSet=" + this.g + ", checkFilter=" + this.f109h + '}';
    }
}
