package jab;

import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends q5c.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: jab.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0241a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CreateGroupMode.values().length];
                r0[CreateGroupMode.CONVERSATION_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[CreateGroupMode.TOPIC_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }
    }

    static {
    }
}
