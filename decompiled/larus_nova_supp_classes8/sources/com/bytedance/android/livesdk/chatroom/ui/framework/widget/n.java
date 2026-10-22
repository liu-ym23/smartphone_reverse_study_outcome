package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Configuration;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface n extends IAbility {

    public static final class a {
        public final Configuration a;
        public final boolean b;

        public a(Configuration r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
            this.a = r2;
            this.b = r3;
        }
    }

    PropertyOwner sa();
}
