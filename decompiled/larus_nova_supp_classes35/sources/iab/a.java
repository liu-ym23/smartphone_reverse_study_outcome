package iab;

import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.EntryPointAccessors;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class a {
    public static final /* synthetic */ int c = 0;

    @Inject
    public hab.b a;

    @Inject
    public hab.a b;

    /* JADX INFO: renamed from: iab.a$a, reason: collision with other inner class name */
    public static final class C0236a {
        public static a a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).e();
        }
    }

    static {
    }

    @Inject
    public a() {
    }
}
