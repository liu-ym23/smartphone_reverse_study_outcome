package com.ss.android.lark.profile.utils;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IProfileLauncherV2 {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<IProfileLauncherV2> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(IProfileLauncherV2$Companion$instance$2.INSTANCE);
        }

        public static IProfileLauncherV2 a() {
            return (IProfileLauncherV2) b.getValue();
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IProfileLauncherV2 r9, Context r10, String r11, String r12, ContactSource r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r14 & 32) == 0) goto L9;
            String r6 = null;
        L10:
            r9.openUserProfileV2(r10, null, r3, null, null, r6, r13, null);
            return;
        L9:
            r6 = r12;
            goto L10
        L5:
            r3 = r11;
            goto L7
        }
    }

    static {
        a = Companion.a;
    }

    Fragment newUserProfileFragmentV2(Bundle r1);

    void openUserProfileV2(Context r1, Fragment r2, String r3, String r4, Chatter.Type r5, String r6, ContactSource r7, Integer r8);
}
