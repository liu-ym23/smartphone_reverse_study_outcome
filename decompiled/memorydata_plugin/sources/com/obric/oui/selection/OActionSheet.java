package com.obric.oui.selection;

import android.util.Log;
import com.obric.oui.sheet.OInsetSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/selection/OActionSheet;", "Lcom/obric/oui/sheet/OInsetSheet;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/selection/OActionSheet$Companion$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/selection/OActionSheet$Companion$Modifier;)V", "dismiss", "", "genHeaderView", "Landroid/view/View;", "title", "", "des", "onClose", "Lkotlin/Function0;", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheet extends OInsetSheet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f14444a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion;", "", "()V", "TAG", "", "ItemStyle", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "", "(Ljava/lang/String;I)V", "LIST_BUTTON", "LIST_TEXT_ONLY", "LIST_ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum ItemStyle extends Enum<ItemStyle> {
            private static final /* synthetic */ ItemStyle[] $VALUES = null;
            public static final ItemStyle LIST_BUTTON = null;
            public static final ItemStyle LIST_ICON_AND_TEXT = null;
            public static final ItemStyle LIST_TEXT_ONLY = null;

            private static final /* synthetic */ ItemStyle[] $values() {
                return new ItemStyle[]{LIST_BUTTON, LIST_TEXT_ONLY, LIST_ICON_AND_TEXT};
            }

            static {
                LIST_BUTTON = new ItemStyle("LIST_BUTTON", 0);
                LIST_TEXT_ONLY = new ItemStyle("LIST_TEXT_ONLY", 1);
                LIST_ICON_AND_TEXT = new ItemStyle("LIST_ICON_AND_TEXT", 2);
                $VALUES = $values();
            }

            private ItemStyle(String r1, int r2) {
                super(r1, r2);
            }

            public static ItemStyle valueOf(String r2) {
                return (ItemStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ItemStyle.class, r2), ItemStyle.class, "com.obric.memorydata.plugin");
            }

            public static ItemStyle[] values() {
                return (ItemStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ItemStyle[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14444a = new Companion(null);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OSelectionSheet", "dismiss failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public void show() {
        super.show();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OSelectionSheet", "show failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
