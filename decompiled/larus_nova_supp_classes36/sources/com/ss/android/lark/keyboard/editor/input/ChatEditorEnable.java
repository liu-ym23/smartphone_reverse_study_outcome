package com.ss.android.lark.keyboard.editor.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/editor/input/ChatEditorEnable;", "Lcom/ss/android/lark/keyboard/event/Notify;", "", "<init>", "(Ljava/lang/String;I)V", "Enable", "Disable", "getTag", "", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ChatEditorEnable extends Enum<ChatEditorEnable> implements com.ss.android.lark.keyboard.event.q {
    public static final ChatEditorEnable Disable = null;
    public static final ChatEditorEnable Enable = null;
    public static final /* synthetic */ ChatEditorEnable[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatEditorEnable.values().length];
            r0[ChatEditorEnable.Enable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ChatEditorEnable.Disable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<ChatEditorEnable> getEntries() {
        return b;
    }

    static {
        ChatEditorEnable r0 = new ChatEditorEnable("Enable", 0);
        Enable = r0;
        ChatEditorEnable r1 = new ChatEditorEnable("Disable", 1);
        Disable = r1;
        ChatEditorEnable[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatEditorEnable[] values() {
        return (ChatEditorEnable[]) a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "Enable";
    L5:
        if (r0 != 2) goto L8;
        return "Disable";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static ChatEditorEnable valueOf(String r1) {
        return (ChatEditorEnable) r27.a.a(ChatEditorEnable.class, r1);
    }

    public ChatEditorEnable(String r1, int r2) {
        super(r1, r2);
    }
}
