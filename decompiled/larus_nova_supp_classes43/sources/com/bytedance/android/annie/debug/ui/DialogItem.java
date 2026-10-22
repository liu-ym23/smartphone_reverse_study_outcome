package com.bytedance.android.annie.debug.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.common.utility.android.ClipboardCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class DialogItem {
    public final String a;
    public final String b;
    public final boolean c;
    public View.OnClickListener d;
    public final CompoundButton.OnCheckedChangeListener e;
    public ItemType f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogItem$ItemType;", "", "DUMMY_TITLE", "JUMP_TITLE", "KV_TEXT", "VALUE_TEXT", "SWITCH", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ItemType extends Enum<ItemType> {
        public static final ItemType DUMMY_TITLE = null;
        public static final ItemType JUMP_TITLE = null;
        public static final ItemType KV_TEXT = null;
        public static final ItemType SWITCH = null;
        public static final ItemType VALUE_TEXT = null;
        public static final /* synthetic */ ItemType[] a = null;

        public static ItemType valueOf(String r1) {
            return (ItemType) r27.a.a(ItemType.class, r1);
        }

        public static ItemType[] values() {
            return (ItemType[]) a.clone();
        }

        static {
            ItemType r0 = new ItemType("DUMMY_TITLE", 0);
            DUMMY_TITLE = r0;
            ItemType r1 = new ItemType("JUMP_TITLE", 1);
            JUMP_TITLE = r1;
            ItemType r10 = new ItemType("KV_TEXT", 2);
            KV_TEXT = r10;
            ItemType r11 = new ItemType("VALUE_TEXT", 3);
            VALUE_TEXT = r11;
            ItemType r12 = new ItemType("SWITCH", 4);
            SWITCH = r12;
            a = new ItemType[]{r0, r1, r10, r11, r12};
        }

        public ItemType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ DialogItem b;

        public a(Context r1, DialogItem r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            ClipboardCompat.setText(this.a, "", this.b.b);
        }
    }

    public final ItemType getType() {
        ItemType r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public void a(Context r10) {
        String r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        AlertDialog.Builder r11 = new AlertDialog.Builder(r10);
        r11.setMessage(this.b).setPositiveButton("确定", new a(r10, this));
        r11.show();
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public DialogItem(String r10, String r11, View.OnClickListener r12) {
        this.a = r10;
        this.b = r11;
        this.d = r12;
        if (r10 == null) goto L12;
        if (r11 != null) goto L10;
        if (r12 != null) goto L8;
        ItemType r13 = ItemType.DUMMY_TITLE;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.f = r13;
        return;
    L8:
        ItemType r14 = ItemType.JUMP_TITLE;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.f = r14;
        return;
    L10:
        ItemType r15 = ItemType.KV_TEXT;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.f = r15;
        return;
    L12:
        ItemType r16 = ItemType.VALUE_TEXT;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.f = r16;
    }

    public DialogItem(String r1, boolean r10, CompoundButton.OnCheckedChangeListener r11) {
        this.a = r1;
        this.e = r11;
        ItemType r12 = ItemType.SWITCH;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.f = r12;
        this.c = r10;
    }

    public /* synthetic */ DialogItem(String r10, String r11, View.OnClickListener r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}
