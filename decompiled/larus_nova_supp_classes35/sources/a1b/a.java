package a1b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$LarkletConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: a1b.a$a, reason: collision with other inner class name */
    public static final class C0000a {
    }

    public final class b extends AbsChameleonHandler<Unit> {
        public final String a;

        public b() {
            this.a = LKAPIModules.App.GetLarkletConfig.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r4) {
            Intrinsics.checkNotNullParameter(r4, "callback");
            r4.success(new IApp$LarkletConfig(new ArrayList(), BuildConfig.FLAVOR));
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
