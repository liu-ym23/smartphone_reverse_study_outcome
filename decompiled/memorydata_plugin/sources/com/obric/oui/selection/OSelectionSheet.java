package com.obric.oui.selection;

import android.util.Log;
import com.obric.oui.sheet.OInsetSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016JD\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet;", "Lcom/obric/oui/sheet/OInsetSheet;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/selection/OSelectionSheet$Companion$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/selection/OSelectionSheet$Companion$Modifier;)V", "dismiss", "", "genHeaderView", "Landroid/view/View;", "title", "", "titleBarControlType", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "onClose", "Lkotlin/Function0;", "onConfirm", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionSheet extends OInsetSheet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f14451a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion;", "", "()V", "TAG", "", "ItemStyle", "Modifier", "SelectionType", "TitleBarControlType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "", "(Ljava/lang/String;I)V", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum ItemStyle extends Enum<ItemStyle> {
            private static final /* synthetic */ ItemStyle[] $VALUES = null;
            public static final ItemStyle ICON_AND_TEXT = null;
            public static final ItemStyle TEXT_ONLY = null;

            private static final /* synthetic */ ItemStyle[] $values() {
                return new ItemStyle[]{TEXT_ONLY, ICON_AND_TEXT};
            }

            static {
                TEXT_ONLY = new ItemStyle("TEXT_ONLY", 0);
                ICON_AND_TEXT = new ItemStyle("ICON_AND_TEXT", 1);
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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum SelectionType extends Enum<SelectionType> {
            private static final /* synthetic */ SelectionType[] $VALUES = null;
            public static final SelectionType MULTI = null;
            public static final SelectionType NONE = null;
            public static final SelectionType SINGLE = null;

            private static final /* synthetic */ SelectionType[] $values() {
                return new SelectionType[]{SINGLE, MULTI, NONE};
            }

            static {
                SINGLE = new SelectionType("SINGLE", 0);
                MULTI = new SelectionType("MULTI", 1);
                NONE = new SelectionType("NONE", 2);
                $VALUES = $values();
            }

            private SelectionType(String r1, int r2) {
                super(r1, r2);
            }

            public static SelectionType valueOf(String r2) {
                return (SelectionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SelectionType.class, r2), SelectionType.class, "com.obric.memorydata.plugin");
            }

            public static SelectionType[] values() {
                return (SelectionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SelectionType[].class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "", "(Ljava/lang/String;I)V", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum TitleBarControlType extends Enum<TitleBarControlType> {
            private static final /* synthetic */ TitleBarControlType[] $VALUES = null;
            public static final TitleBarControlType CLOSE_AND_CONFIRM = null;
            public static final TitleBarControlType CLOSE_ONLY = null;

            private static final /* synthetic */ TitleBarControlType[] $values() {
                return new TitleBarControlType[]{CLOSE_ONLY, CLOSE_AND_CONFIRM};
            }

            static {
                CLOSE_ONLY = new TitleBarControlType("CLOSE_ONLY", 0);
                CLOSE_AND_CONFIRM = new TitleBarControlType("CLOSE_AND_CONFIRM", 1);
                $VALUES = $values();
            }

            private TitleBarControlType(String r1, int r2) {
                super(r1, r2);
            }

            public static TitleBarControlType valueOf(String r2) {
                return (TitleBarControlType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TitleBarControlType.class, r2), TitleBarControlType.class, "com.obric.memorydata.plugin");
            }

            public static TitleBarControlType[] values() {
                return (TitleBarControlType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TitleBarControlType[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14451a = new Companion(null);
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
