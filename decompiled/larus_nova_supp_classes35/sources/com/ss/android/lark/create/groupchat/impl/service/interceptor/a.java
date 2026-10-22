package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$TextType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.create.groupchat.impl.service.interceptor.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0190a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreateGroupScene.values().length];
            r0[CreateGroupScene.PLUS_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[CreateGroupScene.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[CreateGroupScene.ADD_GROUP_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[CreateGroupScene.FORWARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[CreateGroupScene.CREATE_SECRET_CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[CreateGroupScene.CREATE_DEPARTMENT_CHAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final CoroutineScope a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof AppCompatActivity) == false) goto L7;
        return LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) r1);
    L7:
        return GlobalScope.INSTANCE;
    }

    @JvmStatic
    public static final CreateGroupExtraParams$TextType b(CreateGroupScene r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        switch(C0190a.a[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L13:
        return CreateGroupExtraParams$TextType.PLUS;
    L14:
        return CreateGroupExtraParams$TextType.PLUS;
    L15:
        return CreateGroupExtraParams$TextType.FROM_FORWARD;
    L16:
        return CreateGroupExtraParams$TextType.FROM_INNER_GROUP;
    L17:
        return CreateGroupExtraParams$TextType.FROM_P2P;
    L12:
        return CreateGroupExtraParams$TextType.PLUS;
    }
}
