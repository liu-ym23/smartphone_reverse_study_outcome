package androidx.core.app;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class NotificationCompat$Style {
    CharSequence mBigContentTitle;
    protected NotificationCompat$Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;

    private static float constrain(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        if (r1 > r3) goto L8;
        return r1;
    L8:
        return r3;
    }

    public void apply(NotificationBuilderWithBuilderAccessor r1) {
    }

    public boolean displayCustomViewInline() {
        return false;
    }

    public String getClassName() {
        return null;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r1) {
        return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r1) {
        return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r1) {
        return null;
    }

    private int calculateTopPadding() {
        Resources r0 = this.mBuilder.mContext.getResources();
        int r1 = r0.getDimensionPixelSize(2131167854);
        int r2 = r0.getDimensionPixelSize(2131167855);
        float r3 = (constrain(r0.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round(((1.0f - r3) * r1) + (r3 * r2));
    }

    public Notification build() {
        NotificationCompat$Builder r0 = this.mBuilder;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.build();
    }

    public NotificationCompat$Style() {
        this.mSummaryTextSet = false;
    }

    public static NotificationCompat$Style constructCompatStyleByName(String r2) {
        if (r2 == null) goto L44;
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -716705180: goto L27;
            case -171946061: goto L23;
            case 714386739: goto L19;
            case 912942987: goto L15;
            case 919595044: goto L11;
            case 2090799565: goto L7;
            default: goto L30;
        };
    L30:
        switch(r1) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L46;
        };
    L46:
        return null;
    L33:
        return new NotificationCompat.MessagingStyle();
    L35:
        return new NotificationCompat$BigTextStyle();
    L37:
        return new NotificationCompat.InboxStyle();
    L39:
        return new NotificationCompat.CallStyle();
    L41:
        return new NotificationCompat.BigPictureStyle();
    L43:
        return new NotificationCompat.DecoratedCustomViewStyle();
    L7:
        if (r2.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L30;
        r1 = 5;
        goto L30
    L11:
        if (r2.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L30;
        r1 = 4;
        goto L30
    L15:
        if (r2.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L30;
        r1 = 3;
        goto L30
    L19:
        if (r2.equals("androidx.core.app.NotificationCompat$CallStyle") == false) goto L30;
        r1 = 2;
        goto L30
    L23:
        if (r2.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L30;
        r1 = 1;
        goto L30
    L27:
        if (r2.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L30;
        r1 = 0;
        goto L30
    L44:
        return null;
    }

    private static NotificationCompat$Style constructCompatStyleByPlatformName(String r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.equals(Notification.BigPictureStyle.class.getName()) == false) goto L10;
        return new NotificationCompat.BigPictureStyle();
    L10:
        if (r3.equals(Notification.BigTextStyle.class.getName()) == false) goto L14;
        return new NotificationCompat$BigTextStyle();
    L14:
        if (r3.equals(Notification.InboxStyle.class.getName()) == false) goto L18;
        return new NotificationCompat.InboxStyle();
    L18:
        if (Build.VERSION.SDK_INT >= 24) goto L20;
    L27:
        return null;
    L20:
        if (r3.equals(Notification.MessagingStyle.class.getName()) == false) goto L24;
        return new NotificationCompat.MessagingStyle();
    L24:
        if (r3.equals(Notification.DecoratedCustomViewStyle.class.getName()) == false) goto L27;
        return new NotificationCompat.DecoratedCustomViewStyle();
    }

    public static NotificationCompat$Style constructCompatStyleForBundle(Bundle r1) {
        NotificationCompat$Style r0 = constructCompatStyleByName(r1.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r1.containsKey("android.selfDisplayName") == true) goto L32;
        if (r1.containsKey("android.messagingStyleUser") == true) goto L32;
        if (r1.containsKey("android.picture") == true) goto L30;
        if (r1.containsKey("android.pictureIcon") == true) goto L30;
        if (r1.containsKey("android.bigText") == false) goto L20;
        return new NotificationCompat$BigTextStyle();
    L20:
        if (r1.containsKey("android.textLines") == false) goto L24;
        return new NotificationCompat.InboxStyle();
    L24:
        if (r1.containsKey("android.callType") == false) goto L28;
        return new NotificationCompat.CallStyle();
    L28:
        return constructCompatStyleByPlatformName(r1.getString("android.template"));
    L30:
        return new NotificationCompat.BigPictureStyle();
    L32:
        return new NotificationCompat.MessagingStyle();
    }

    public static NotificationCompat$Style constructStyleForExtras(Bundle r2) {
        NotificationCompat$Style r0 = constructCompatStyleForBundle(r2);
        if (r0 != null) goto L8;
        return null;
    L8:
        r0.restoreFromCompatExtras(r2);     // Catch: ClassCastException -> L7
        return r0;
    L7:
        return null;
    }

    public static NotificationCompat$Style extractStyleFromNotification(Notification r0) {
        Bundle r1 = NotificationCompat.getExtras(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return constructStyleForExtras(r1);
    }

    private void hideNormalContent(RemoteViews r3) {
        r3.setViewVisibility(2131388772, 8);
        r3.setViewVisibility(2131388369, 8);
        r3.setViewVisibility(2131388367, 8);
    }

    public void addCompatExtras(Bundle r3) {
        if (this.mSummaryTextSet == false) goto L5;
        r3.putCharSequence("android.summaryText", this.mSummaryText);
    L5:
        CharSequence r0 = this.mBigContentTitle;
        if (r0 == null) goto L8;
        r3.putCharSequence("android.title.big", r0);
    L8:
        String r1 = getClassName();
        if (r1 == null) goto L12;
        r3.putString("androidx.core.app.extra.COMPAT_TEMPLATE", r1);
        return;
    }

    public void clearCompatExtraKeys(Bundle r2) {
        r2.remove("android.summaryText");
        r2.remove("android.title.big");
        r2.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
    }

    public void restoreFromCompatExtras(Bundle r3) {
        if (r3.containsKey("android.summaryText") == false) goto L5;
        this.mSummaryText = r3.getCharSequence("android.summaryText");
        this.mSummaryTextSet = true;
    L5:
        this.mBigContentTitle = r3.getCharSequence("android.title.big");
    }

    public void setBuilder(NotificationCompat$Builder r2) {
        if (this.mBuilder == r2) goto L8;
        this.mBuilder = r2;
        if (r2 == null) goto L9;
        r2.setStyle(this);
        return;
    L9:
        return;
    }

    public void buildIntoRemoteViews(RemoteViews r8, RemoteViews r9) {
        hideNormalContent(r8);
        r8.removeAllViews(2131381052);
        r8.addView(2131381052, r9.clone());
        r8.setViewVisibility(2131381052, 0);
        r8.setViewPadding(2131381053, 0, calculateTopPadding(), 0, 0);
    }

    public Bitmap createColoredBitmap(int r2, int r3) {
        return createColoredBitmap(r2, r3, 0);
    }

    public Bitmap createColoredBitmap(IconCompat r2, int r3) {
        return createColoredBitmap(r2, r3, 0);
    }

    private Bitmap createColoredBitmap(IconCompat r4, int r5, int r6) {
        Drawable r7 = r4.loadDrawable(this.mBuilder.mContext);
        if (r6 != 0) goto L5;
        int r0 = r7.getIntrinsicWidth();
    L6:
        if (r6 != 0) goto L8;
        r6 = r7.getIntrinsicHeight();
    L8:
        Bitmap r1 = Bitmap.createBitmap(r0, r6, Bitmap.Config.ARGB_8888);
        r7.setBounds(0, 0, r0, r6);
        if (r5 == 0) goto L11;
        r7.mutate().setColorFilter(new PorterDuffColorFilter(r5, PorterDuff.Mode.SRC_IN));
    L11:
        r7.draw(new Canvas(r1));
        return r1;
    L5:
        r0 = r6;
        goto L6
    }

    public RemoteViews applyStandardTemplate(boolean r13, int r14, boolean r15) {
        Resources r0 = this.mBuilder.mContext.getResources();
        RemoteViews r7 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r14);
        this.mBuilder.getPriority();
        int r16 = Build.VERSION.SDK_INT;
        NotificationCompat$Builder r1 = this.mBuilder;
        int r8 = 0;
        if (r1.mLargeIcon == null) goto L9;
        r7.setViewVisibility(2131374718, 0);
        r7.setImageViewBitmap(2131374718, createColoredBitmap(this.mBuilder.mLargeIcon, 0));
        if (r13 == true) goto L7;
    L13:
        CharSequence r17 = this.mBuilder.mContentTitle;
        if (r17 == null) goto L16;
        r7.setTextViewText(2131388772, r17);
    L16:
        CharSequence r18 = this.mBuilder.mContentText;
        boolean r9 = true;
        if (r18 == null) goto L19;
        r7.setTextViewText(2131388367, r18);
        boolean r19 = true;
    L20:
        NotificationCompat$Builder r2 = this.mBuilder;
        CharSequence r3 = r2.mContentInfo;
        if (r3 == null) goto L25;
        r7.setTextViewText(2131375279, r3);
        r7.setViewVisibility(2131375279, 0);
    L23:
        r19 = true;
        boolean r11 = true;
    L32:
        CharSequence r4 = this.mBuilder.mSubText;
        if (r4 == null) goto L38;
        r7.setTextViewText(2131388367, r4);
        CharSequence r5 = this.mBuilder.mContentText;
        if (r5 == null) goto L37;
        r7.setTextViewText(2131388369, r5);
        r7.setViewVisibility(2131388369, 0);
        boolean r6 = true;
    L39:
        if (r6 == false) goto L44;
        if (r15 == false) goto L42;
        r7.setTextViewTextSize(2131388367, 0, r0.getDimensionPixelSize(2131167853));
    L42:
        r7.setViewPadding(2131377892, 0, 0, 0, 0);
    L44:
        if (this.mBuilder.getWhenIfShowing() != 0) goto L46;
        r9 = r11;
    L54:
        if (r9 == false) goto L56;
        int r110 = 0;
    L57:
        r7.setViewVisibility(2131384626, r110);
        if (r19 == true) goto L61;
        r8 = 8;
    L61:
        r7.setViewVisibility(2131377900, r8);
        return r7;
    L56:
        r110 = 8;
        goto L57
    L46:
        if (this.mBuilder.mUseChronometer == false) goto L52;
        r7.setViewVisibility(2131365715, 0);
        r7.setLong(2131365715, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
        r7.setBoolean(2131365715, "setStarted", true);
        boolean r10 = this.mBuilder.mChronometerCountDown;
        if (r10 == false) goto L54;
        if (r16 < 24) goto L54;
        Api24Impl.setChronometerCountDown(r7, 2131365715, r10);
        goto L54
    L52:
        r7.setViewVisibility(2131388654, 0);
        r7.setLong(2131388654, "setTime", this.mBuilder.getWhenIfShowing());
        goto L54
    L37:
        r7.setViewVisibility(2131388369, 8);
    L38:
        r6 = false;
        goto L39
    L25:
        if (r2.mNumber > 0) goto L27;
        r7.setViewVisibility(2131375279, 8);
        r11 = false;
        goto L32
    L27:
        if (this.mBuilder.mNumber <= r0.getInteger(2131427403)) goto L29;
        r7.setTextViewText(2131375279, r0.getString(2131914172));
    L30:
        r7.setViewVisibility(2131375279, 0);
        goto L23
    L29:
        r7.setTextViewText(2131375279, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
        goto L30
    L19:
        r19 = false;
        goto L20
    L7:
        if (this.mBuilder.mNotification.icon == 0) goto L13;
        int r111 = r0.getDimensionPixelSize(2131167849);
        int r12 = r111 - (r0.getDimensionPixelSize(2131167851) * 2);
        NotificationCompat$Builder r20 = this.mBuilder;
        r7.setImageViewBitmap(2131384584, createIconWithBackground(r20.mNotification.icon, r111, r12, r20.getColor()));
        r7.setViewVisibility(2131384584, 0);
        goto L13
    L9:
        if (r13 == false) goto L13;
        if (r1.mNotification.icon == 0) goto L13;
        r7.setViewVisibility(2131374718, 0);
        int r112 = r0.getDimensionPixelSize(2131167846) - r0.getDimensionPixelSize(2131167843);
        int r21 = r0.getDimensionPixelSize(2131167852);
        NotificationCompat$Builder r22 = this.mBuilder;
        r7.setImageViewBitmap(2131374718, createIconWithBackground(r22.mNotification.icon, r112, r21, r22.getColor()));
        goto L13
    }

    private Bitmap createColoredBitmap(int r2, int r3, int r4) {
        return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r2), r3, r4);
    }

    private Bitmap createIconWithBackground(int r3, int r4, int r5, int r6) {
        if (r6 != 0) goto L4;
        r6 = 0;
    L4:
        Bitmap r7 = createColoredBitmap(2131244051, r6, r4);
        Canvas r0 = new Canvas(r7);
        Drawable r8 = this.mBuilder.mContext.getResources().getDrawable(r3).mutate();
        r8.setFilterBitmap(true);
        int r9 = (r4 - r5) / 2;
        int r10 = r5 + r9;
        r8.setBounds(r9, r9, r10, r10);
        r8.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        r8.draw(r0);
        return r7;
    }
}
