package hd;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f17300b;

    public /* synthetic */ a(Serializable r5, int r10) {
        this.f17299a = r10;
        this.f17300b = r5;
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map getUserData(CrashType r5) {
        switch(this.f17299a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        HashMap r10 = new HashMap();
        r10.put("bullet_url", (String) this.f17300b);
        return r10;
    L6:
        HashMap r11 = new HashMap();
        r11.put("bullet_url", ((Ref.ObjectRef) this.f17300b).element);
        return r11;
    }
}
