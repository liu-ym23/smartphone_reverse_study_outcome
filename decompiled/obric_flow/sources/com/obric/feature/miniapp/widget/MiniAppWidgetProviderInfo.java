package com.obric.feature.miniapp.widget;

import ai.j0;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u0004\u0018\u00010'J\u0006\u0010(\u001a\u00020\u0006J\b\u0010)\u001a\u00020\tH\u0016J\u0018\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0012H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\r¨\u0006."}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppWidgetProviderInfo;", "Landroid/appwidget/AppWidgetProviderInfo;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "readSelf", "", "(Landroid/os/Parcel;Z)V", "appletId", "", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "definitionId", "getDefinitionId", "setDefinitionId", "minSpanX", "", "getMinSpanX", "()I", "setMinSpanX", "(I)V", "minSpanY", "getMinSpanY", "setMinSpanY", "spanX", "getSpanX", "setSpanX", "spanY", "getSpanY", "setSpanY", "widgetId", "getWidgetId", "setWidgetId", "applyComponentName", "", "className", "getLabel", "", "isCustomWidget", "toString", "writeToParcel", "out", "flags", "Companion", "MiniAppWidgetHost_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MiniAppWidgetProviderInfo extends AppWidgetProviderInfo implements Parcelable {
    public static final String APPLET_PACKAGE_NAME = "com.obric.appletapp";

    @JvmField
    public static final Parcelable.Creator<MiniAppWidgetProviderInfo> CREATOR = null;
    public static final Companion Companion = null;
    private String appletId;
    private String definitionId;
    private int minSpanX;
    private int minSpanY;
    private int spanX;
    private int spanY;
    private String widgetId;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J@\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppWidgetProviderInfo$Companion;", "", "()V", "APPLET_PACKAGE_NAME", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/feature/miniapp/widget/MiniAppWidgetProviderInfo;", "create", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "cn", "Landroid/content/ComponentName;", "context", "Landroid/content/Context;", "appletId", "widgetId", "definitionId", "spanX", "", "spanY", "isMiniAppWidgetComponent", "", "MiniAppWidgetHost_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static /* synthetic */ MiniAppWidgetProviderInfo create$default(Companion r10, Context r11, String r12, String r13, String r14, int r15, int r16, int r17, Object r18) {
            if ((r17 & 8) == 0) goto L5;
            r14 = null;
        L5:
            String r5 = r14;
            if ((r17 & 16) == 0) goto L8;
            int r19 = 0;
        L10:
            if ((r17 & 32) == 0) goto L12;
            int r20 = 0;
        L14:
            return r10.create(r11, r12, r13, r5, r19, r20);
        L12:
            r20 = r16;
            goto L14
        L8:
            r19 = r15;
            goto L10
        }

        public final MiniAppWidgetProviderInfo create(Context r10, String r11, String r12, String r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "appletId");
            Intrinsics.checkNotNullParameter(r12, "widgetId");
            return create(AppWidgetManager.getInstance(r10), new ComponentName("com.obric.appletapp", MiniAppWidgetComponentNameCodec.INSTANCE.buildClassName(r11, r12, r13, r14, r15)));
        }

        @JvmStatic
        public final boolean isMiniAppWidgetComponent(ComponentName r5) {
            if (r5 == null) goto L4;
            String r10 = r5.getPackageName();
        L6:
            if (Intrinsics.areEqual(r10, "com.obric.appletapp") == true) goto L8;
            return false;
        L8:
            MiniAppWidgetComponentData r11 = MiniAppWidgetComponentNameCodec.INSTANCE.parse(r5.getClassName());
            if (r11.getAppletId() != null) goto L11;
            return false;
        L11:
            if (r11.getWidgetId() == null) goto L15;
            return true;
        L15:
            return false;
        L4:
            r10 = null;
            goto L6
        }

        private Companion() {
        }

        @JvmStatic
        public final MiniAppWidgetProviderInfo create(AppWidgetManager r5, ComponentName r10) {
            Intrinsics.checkNotNullParameter(r5, "appWidgetManager");
            Intrinsics.checkNotNullParameter(r10, "cn");
            List<AppWidgetProviderInfo> r11 = r5.getInstalledProvidersForProfile(Process.myUserHandle());
            DefaultConstructorMarker r12 = null;
            if (r11.isEmpty() == false) goto L5;
            return null;
        L5:
            Parcel r13 = Parcel.obtain();
            r11.get(0).writeToParcel(r13, 0);
            r13.setDataPosition(0);
            Intrinsics.checkNotNull(r13);
            MiniAppWidgetProviderInfo r14 = new MiniAppWidgetProviderInfo(r13, false, r12);
            r13.recycle();
            ((AppWidgetProviderInfo) r14).label = null;
            ((AppWidgetProviderInfo) r14).provider = r10;
            MiniAppWidgetProviderInfo.access$applyComponentName(r14, r10.getClassName());
            ((AppWidgetProviderInfo) r14).initialLayout = 0;
            return r14;
        }
    }

    static {
        Companion = new Companion(null);
        CREATOR = new MiniAppWidgetProviderInfo$Companion$CREATOR$1();
    }

    public /* synthetic */ MiniAppWidgetProviderInfo(Parcel r5, boolean r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ void access$applyComponentName(MiniAppWidgetProviderInfo r5, String r10) {
        r5.applyComponentName(r10);
    }

    private final void applyComponentName(String r5) {
        MiniAppWidgetComponentData r10 = MiniAppWidgetComponentNameCodec.INSTANCE.parse(r5);
        this.appletId = r10.getAppletId();
        this.widgetId = r10.getWidgetId();
        this.definitionId = r10.getDefinitionId();
    }

    @JvmStatic
    public static final MiniAppWidgetProviderInfo create(AppWidgetManager r5, ComponentName r10) {
        return Companion.create(r5, r10);
    }

    @JvmStatic
    public static final boolean isMiniAppWidgetComponent(ComponentName r5) {
        return Companion.isMiniAppWidgetComponent(r5);
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getDefinitionId() {
        return this.definitionId;
    }

    public final CharSequence getLabel() {
        return ((AppWidgetProviderInfo) this).label;
    }

    public final int getMinSpanX() {
        return this.minSpanX;
    }

    public final int getMinSpanY() {
        return this.minSpanY;
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final boolean isCustomWidget() {
        return true;
    }

    public final void setAppletId(String r5) {
        this.appletId = r5;
    }

    public final void setDefinitionId(String r5) {
        this.definitionId = r5;
    }

    public final void setMinSpanX(int r5) {
        this.minSpanX = r5;
    }

    public final void setMinSpanY(int r5) {
        this.minSpanY = r5;
    }

    public final void setSpanX(int r5) {
        this.spanX = r5;
    }

    public final void setSpanY(int r5) {
        this.spanY = r5;
    }

    public final void setWidgetId(String r5) {
        this.widgetId = r5;
    }

    @Override // android.appwidget.AppWidgetProviderInfo
    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.definitionId;
        return j0.q(androidx.constraintlayout.motion.widget.a.y("MiniAppWidgetProviderInfo(appletId=", r5, ", widgetId=", r10, ", definitionId="), r11, ")");
    }

    @Override // android.appwidget.AppWidgetProviderInfo, android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "out");
        super.writeToParcel(r5, r10);
        ComponentName r11 = ((AppWidgetProviderInfo) this).provider;
        String r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.getPackageName();
    L6:
        if (r13 != null) goto L8;
        r13 = "com.obric.appletapp";
    L8:
        r5.writeString(r13);
        ComponentName r14 = ((AppWidgetProviderInfo) this).provider;
        if (r14 == null) goto L11;
        r12 = r14.getClassName();
    L11:
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r5.writeString(r12);
        r5.writeString(((AppWidgetProviderInfo) this).label);
        r5.writeInt(((AppWidgetProviderInfo) this).initialLayout);
        r5.writeInt(((AppWidgetProviderInfo) this).icon);
        r5.writeInt(((AppWidgetProviderInfo) this).previewImage);
        r5.writeInt(((AppWidgetProviderInfo) this).resizeMode);
        r5.writeInt(this.spanX);
        r5.writeInt(this.spanY);
        r5.writeInt(this.minSpanX);
        r5.writeInt(this.minSpanY);
        return;
    L5:
        r13 = null;
        goto L6
    }

    private MiniAppWidgetProviderInfo(Parcel r5, boolean r10) {
        super(r5);
        if (r10 == false) goto L9;
        String r11 = r5.readString();
        if (r11 != null) goto L7;
        r11 = "com.obric.appletapp";
    L7:
        String r12 = r5.readString();
        Intrinsics.checkNotNull(r12);
        ((AppWidgetProviderInfo) this).provider = new ComponentName(r11, r12);
        ((AppWidgetProviderInfo) this).label = r5.readString();
        ((AppWidgetProviderInfo) this).initialLayout = r5.readInt();
        ((AppWidgetProviderInfo) this).icon = r5.readInt();
        ((AppWidgetProviderInfo) this).previewImage = r5.readInt();
        ((AppWidgetProviderInfo) this).resizeMode = r5.readInt();
        this.spanX = r5.readInt();
        this.spanY = r5.readInt();
        this.minSpanX = r5.readInt();
        this.minSpanY = r5.readInt();
        applyComponentName(r12);
        return;
    }
}
