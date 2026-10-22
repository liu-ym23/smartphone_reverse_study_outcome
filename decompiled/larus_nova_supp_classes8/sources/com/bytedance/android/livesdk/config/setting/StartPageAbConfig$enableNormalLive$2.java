package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.ls;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3})
final class StartPageAbConfig$enableNormalLive$2 extends Lambda implements Function0<Boolean> {
    public static final StartPageAbConfig$enableNormalLive$2 INSTANCE = null;

    static {
        INSTANCE = new StartPageAbConfig$enableNormalLive$2();
    }

    public StartPageAbConfig$enableNormalLive$2() {
        super(0);
    }

    public final Boolean invoke() {
        return ls.a.getValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m484invoke() {
        return invoke();
    }
}
