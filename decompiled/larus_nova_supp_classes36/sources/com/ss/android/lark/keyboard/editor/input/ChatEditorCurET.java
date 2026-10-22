package com.ss.android.lark.keyboard.editor.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/editor/input/ChatEditorCurET;", "Lcom/ss/android/lark/keyboard/event/Notify;", "", "<init>", "(Ljava/lang/String;I)V", "Title", "Content", "getTag", "", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ChatEditorCurET extends Enum<ChatEditorCurET> implements com.ss.android.lark.keyboard.event.q {
    public static final ChatEditorCurET Content = null;
    public static final ChatEditorCurET Title = null;
    public static final /* synthetic */ ChatEditorCurET[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatEditorCurET.values().length];
            r0[ChatEditorCurET.Title.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ChatEditorCurET.Content.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<ChatEditorCurET> getEntries() {
        return b;
    }

    static {
        ChatEditorCurET r0 = new ChatEditorCurET("Title", 0);
        Title = r0;
        ChatEditorCurET r1 = new ChatEditorCurET("Content", 1);
        Content = r1;
        ChatEditorCurET[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatEditorCurET[] values() {
        return (ChatEditorCurET[]) a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "title";
    L5:
        if (r0 != 2) goto L8;
        return "content";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static ChatEditorCurET valueOf(String r1) {
        return (ChatEditorCurET) r27.a.a(ChatEditorCurET.class, r1);
    }

    public ChatEditorCurET(String r1, int r2) {
        super(r1, r2);
    }
}
