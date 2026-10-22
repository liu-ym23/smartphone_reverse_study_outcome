package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR%\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "title", "Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "content", "buttons", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogButton;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;Ljava/util/ArrayList;)V", "getTitle", "()Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "getContent", "getButtons", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "DialogButtonType", "DialogButton", "DialogItem", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowDialogAction extends BaseAction {
    private final ArrayList<a> buttons;
    private final DialogItem content;
    private final DialogItem title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogButtonType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PRIMARY", "DANGER", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DialogButtonType extends Enum<DialogButtonType> {
        public static final a Companion = null;
        public static final DialogButtonType DANGER = null;
        public static final DialogButtonType DEFAULT = null;
        public static final DialogButtonType PRIMARY = null;
        public static final /* synthetic */ DialogButtonType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DialogButtonType> getEntries() {
            return b;
        }

        static {
            DialogButtonType r0 = new DialogButtonType("DEFAULT", 0, 0);
            DEFAULT = r0;
            DialogButtonType r1 = new DialogButtonType("PRIMARY", 1, 1);
            PRIMARY = r1;
            DialogButtonType r3 = new DialogButtonType("DANGER", 2, 2);
            DANGER = r3;
            DialogButtonType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static DialogButtonType[] values() {
            return (DialogButtonType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DialogButtonType valueOf(String r1) {
            return (DialogButtonType) r27.a.a(DialogButtonType.class, r1);
        }

        public DialogButtonType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "Ljava/io/Serializable;", "text", BuildConfig.FLAVOR, "numberOfLines", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getNumberOfLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DialogItem implements Serializable {
        private final Integer numberOfLines;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public DialogItem() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DialogItem copy$default(DialogItem r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.numberOfLines;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.text;
        }

        public final Integer component2() {
            return this.numberOfLines;
        }

        public final DialogItem copy(String r2, Integer r3) {
            return new DialogItem(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DialogItem) == true) goto L8;
            return false;
        L8:
            DialogItem r6 = (DialogItem) r5;
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.numberOfLines, r6.numberOfLines) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.text;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.numberOfLines;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "DialogItem(text=" + this.text + ", numberOfLines=" + this.numberOfLines + ')';
        }

        public final Integer getNumberOfLines() {
            return this.numberOfLines;
        }

        public final String getText() {
            return this.text;
        }

        public DialogItem(String r1, Integer r2) {
            this.text = r1;
            this.numberOfLines = r2;
        }

        public /* synthetic */ DialogItem(String r1, Integer r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = BuildConfig.FLAVOR;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final DialogButtonType b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            DialogButtonType r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DialogButton(text=" + this.a + ", type=" + this.b + ", actionId=" + this.c + ')';
        }

        public final DialogButtonType getType() {
            return this.b;
        }

        public a(String r1, DialogButtonType r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowDialogAction copy$default(ShowDialogAction r0, DialogItem r1, DialogItem r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.buttons;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final DialogItem component1() {
        return this.title;
    }

    public final DialogItem component2() {
        return this.content;
    }

    public final ArrayList<a> component3() {
        return this.buttons;
    }

    public final ShowDialogAction copy(DialogItem r2, DialogItem r3, ArrayList<a> r4) {
        return new ShowDialogAction(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShowDialogAction) == true) goto L8;
        return false;
    L8:
        ShowDialogAction r6 = (ShowDialogAction) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.buttons, r6.buttons) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        DialogItem r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        DialogItem r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<a> r7 = this.buttons;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ShowDialogAction(title=" + this.title + ", content=" + this.content + ", buttons=" + this.buttons + ')';
    }

    public final ArrayList<a> getButtons() {
        return this.buttons;
    }

    public final DialogItem getContent() {
        return this.content;
    }

    public final DialogItem getTitle() {
        return this.title;
    }

    public ShowDialogAction(DialogItem r1, DialogItem r2, ArrayList<a> r3) {
        this.title = r1;
        this.content = r2;
        this.buttons = r3;
    }
}
