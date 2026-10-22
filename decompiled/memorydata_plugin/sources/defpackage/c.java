package defpackage;

import com.obric.aiagent.authentication.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"LIntentPolicyController;", "Lcom/obric/aiagent/authentication/IPolicyController;", "<init>", "()V", "REQUIRES_AUTHENTICATION", "", "isSettingKeyEnable", "", "settingKey", "", "getSettingKeyPolicyType", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f115a = null;

    static {
        f115a = new c();
    }

    private c() {
    }

    @Override // com.obric.aiagent.authentication.b
    public boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "settingKey");
        return false;
    }

    @Override // com.obric.aiagent.authentication.b
    public int b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "settingKey");
        return 1;
    }
}
