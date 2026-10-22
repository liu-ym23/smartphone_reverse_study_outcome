package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    @RequiresApi(20)
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static Notification.Builder addAction(Notification.Builder r5, Notification.Action r10) {
            return r5.addAction(r10);
        }

        @DoNotInline
        public static Notification.Action.Builder addExtras(Notification.Action.Builder r5, Bundle r10) {
            return r5.addExtras(r10);
        }

        @DoNotInline
        public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r5, android.app.RemoteInput r10) {
            return r5.addRemoteInput(r10);
        }

        @DoNotInline
        public static Notification.Action build(Notification.Action.Builder r5) {
            return r5.build();
        }

        @DoNotInline
        public static Notification.Action.Builder createBuilder(int r5, CharSequence r10, PendingIntent r11) {
            return new Notification.Action.Builder(r5, r10, r11);
        }

        @DoNotInline
        public static String getGroup(Notification r5) {
            return r5.getGroup();
        }

        @DoNotInline
        public static Notification.Builder setGroup(Notification.Builder r5, String r10) {
            return r5.setGroup(r10);
        }

        @DoNotInline
        public static Notification.Builder setGroupSummary(Notification.Builder r5, boolean r10) {
            return r5.setGroupSummary(r10);
        }

        @DoNotInline
        public static Notification.Builder setLocalOnly(Notification.Builder r5, boolean r10) {
            return r5.setLocalOnly(r10);
        }

        @DoNotInline
        public static Notification.Builder setSortKey(Notification.Builder r5, String r10) {
            return r5.setSortKey(r10);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Notification.Builder addPerson(Notification.Builder r5, String r10) {
            return r5.addPerson(r10);
        }

        @DoNotInline
        public static Notification.Builder setCategory(Notification.Builder r5, String r10) {
            return r5.setCategory(r10);
        }

        @DoNotInline
        public static Notification.Builder setColor(Notification.Builder r5, int r10) {
            return r5.setColor(r10);
        }

        @DoNotInline
        public static Notification.Builder setPublicVersion(Notification.Builder r5, Notification r10) {
            return r5.setPublicVersion(r10);
        }

        @DoNotInline
        public static Notification.Builder setSound(Notification.Builder r5, Uri r10, Object r11) {
            return r5.setSound(r10, (AudioAttributes) r11);
        }

        @DoNotInline
        public static Notification.Builder setVisibility(Notification.Builder r5, int r10) {
            return r5.setVisibility(r10);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder createBuilder(Icon r5, CharSequence r10, PendingIntent r11) {
            return new Notification.Action.Builder(r5, r10, r11);
        }

        @DoNotInline
        public static Notification.Builder setLargeIcon(Notification.Builder r5, Icon r10) {
            return r5.setLargeIcon(r10);
        }

        @DoNotInline
        public static Notification.Builder setSmallIcon(Notification.Builder r5, Object r10) {
            return r5.setSmallIcon((Icon) r10);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r5, boolean r10) {
            return r5.setAllowGeneratedReplies(r10);
        }

        @DoNotInline
        public static Notification.Builder setCustomBigContentView(Notification.Builder r5, RemoteViews r10) {
            return r5.setCustomBigContentView(r10);
        }

        @DoNotInline
        public static Notification.Builder setCustomContentView(Notification.Builder r5, RemoteViews r10) {
            return r5.setCustomContentView(r10);
        }

        @DoNotInline
        public static Notification.Builder setCustomHeadsUpContentView(Notification.Builder r5, RemoteViews r10) {
            return r5.setCustomHeadsUpContentView(r10);
        }

        @DoNotInline
        public static Notification.Builder setRemoteInputHistory(Notification.Builder r5, CharSequence[] r10) {
            return r5.setRemoteInputHistory(r10);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Notification.Builder createBuilder(Context r5, String r10) {
            return new Notification.Builder(r5, r10);
        }

        @DoNotInline
        public static Notification.Builder setBadgeIconType(Notification.Builder r5, int r10) {
            return r5.setBadgeIconType(r10);
        }

        @DoNotInline
        public static Notification.Builder setColorized(Notification.Builder r5, boolean r10) {
            return r5.setColorized(r10);
        }

        @DoNotInline
        public static Notification.Builder setGroupAlertBehavior(Notification.Builder r5, int r10) {
            return r5.setGroupAlertBehavior(r10);
        }

        @DoNotInline
        public static Notification.Builder setSettingsText(Notification.Builder r5, CharSequence r10) {
            return r5.setSettingsText(r10);
        }

        @DoNotInline
        public static Notification.Builder setShortcutId(Notification.Builder r5, String r10) {
            return r5.setShortcutId(r10);
        }

        @DoNotInline
        public static Notification.Builder setTimeoutAfter(Notification.Builder r5, long r10) {
            return r5.setTimeoutAfter(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Notification.Builder addPerson(Notification.Builder r5, android.app.Person r10) {
            return r5.addPerson(r10);
        }

        @DoNotInline
        public static Notification.Action.Builder setSemanticAction(Notification.Action.Builder r5, int r10) {
            return r5.setSemanticAction(r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder r5, boolean r10) {
            return r5.setAllowSystemGeneratedContextualActions(r10);
        }

        @DoNotInline
        public static Notification.Builder setBubbleMetadata(Notification.Builder r5, Notification.BubbleMetadata r10) {
            return r5.setBubbleMetadata(r10);
        }

        @DoNotInline
        public static Notification.Action.Builder setContextual(Notification.Action.Builder r5, boolean r10) {
            return r5.setContextual(r10);
        }

        @DoNotInline
        public static Notification.Builder setLocusId(Notification.Builder r5, Object r10) {
            return r5.setLocusId((LocusId) r10);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r5, boolean r10) {
            return r5.setAuthenticationRequired(r10);
        }

        @DoNotInline
        public static Notification.Builder setForegroundServiceBehavior(Notification.Builder r5, int r10) {
            return r5.setForegroundServiceBehavior(r10);
        }
    }

    public NotificationCompatBuilder(NotificationCompat.Builder r13) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r13;
        Context r5 = r13.mContext;
        this.mContext = r5;
        Notification.Builder r10 = Api26Impl.createBuilder(r5, r13.mChannelId);
        this.mBuilder = r10;
        Notification r11 = r13.mNotification;
        Notification.Builder r12 = r10.setWhen(r11.when).setSmallIcon(r11.icon, r11.iconLevel).setContent(r11.contentView).setTicker(r11.tickerText, r13.mTickerView).setVibrate(r11.vibrate).setLights(r11.ledARGB, r11.ledOnMS, r11.ledOffMS);
        if ((r11.flags & 2) == 0) goto L5;
        boolean r14 = true;
    L6:
        Notification.Builder r15 = r12.setOngoing(r14);
        if ((r11.flags & 8) == 0) goto L9;
        boolean r16 = true;
    L10:
        Notification.Builder r17 = r15.setOnlyAlertOnce(r16);
        if ((r11.flags & 16) == 0) goto L13;
        boolean r18 = true;
    L14:
        Notification.Builder r19 = r17.setAutoCancel(r18).setDefaults(r11.defaults).setContentTitle(r13.mContentTitle).setContentText(r13.mContentText).setContentInfo(r13.mContentInfo).setContentIntent(r13.mContentIntent).setDeleteIntent(r11.deleteIntent);
        PendingIntent r20 = r13.mFullScreenIntent;
        if ((r11.flags & 128) == 0) goto L17;
        boolean r21 = true;
    L18:
        r19.setFullScreenIntent(r20, r21).setNumber(r13.mNumber).setProgress(r13.mProgressMax, r13.mProgress, r13.mProgressIndeterminate);
        IconCompat r22 = r13.mLargeIcon;
        if (r22 != null) goto L21;
        Icon r23 = null;
    L22:
        Api23Impl.setLargeIcon(r10, r23);
        r10.setSubText(r13.mSubText).setUsesChronometer(r13.mUseChronometer).setPriority(r13.mPriority);
        NotificationCompat.Style r24 = r13.mStyle;
        if ((r24 instanceof NotificationCompat.CallStyle) == false) goto L28;
        Iterator<NotificationCompat.Action> r25 = ((NotificationCompat.CallStyle) r24).getActionsListWithSystemActions().iterator();
    L26:
        if (r25.hasNext() == false) goto L32;
        addAction(r25.next());
    L32:
        Bundle r26 = r13.mExtras;
        if (r26 == null) goto L35;
        this.mExtras.putAll(r26);
    L35:
        this.mContentView = r13.mContentView;
        this.mBigContentView = r13.mBigContentView;
        this.mBuilder.setShowWhen(r13.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, r13.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, r13.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, r13.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, r13.mGroupSummary);
        this.mGroupAlertBehavior = r13.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, r13.mCategory);
        Api21Impl.setColor(this.mBuilder, r13.mColor);
        Api21Impl.setVisibility(this.mBuilder, r13.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, r13.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, r11.sound, r11.audioAttributes);
        ArrayList<String> r27 = r13.mPeople;
        if (r27 != null) goto L38;
    L43:
        this.mHeadsUpContentView = r13.mHeadsUpContentView;
        if (r13.mInvisibleActions.size() <= 0) goto L53;
        Bundle r28 = r13.getExtras().getBundle("android.car.EXTENSIONS");
        if (r28 != null) goto L48;
        r28 = new Bundle();
    L48:
        Bundle r29 = new Bundle(r28);
        Bundle r30 = new Bundle();
        int r31 = 0;
    L50:
        if (r31 >= r13.mInvisibleActions.size()) goto L52;
        r30.putBundle(Integer.toString(r31), NotificationCompatJellybean.getBundleForAction(r13.mInvisibleActions.get(r31)));
        r31 = r31 + 1;
        goto L50
    L52:
        r28.putBundle("invisible_actions", r30);
        r29.putBundle("invisible_actions", r30);
        r13.getExtras().putBundle("android.car.EXTENSIONS", r28);
        this.mExtras.putBundle("android.car.EXTENSIONS", r29);
    L53:
        Object r32 = r13.mSmallIcon;
        if (r32 == null) goto L56;
        Api23Impl.setSmallIcon(this.mBuilder, r32);
    L56:
        this.mBuilder.setExtras(r13.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, r13.mRemoteInputHistory);
        RemoteViews r33 = r13.mContentView;
        if (r33 == null) goto L59;
        Api24Impl.setCustomContentView(this.mBuilder, r33);
    L59:
        RemoteViews r34 = r13.mBigContentView;
        if (r34 == null) goto L62;
        Api24Impl.setCustomBigContentView(this.mBuilder, r34);
    L62:
        RemoteViews r35 = r13.mHeadsUpContentView;
        if (r35 == null) goto L65;
        Api24Impl.setCustomHeadsUpContentView(this.mBuilder, r35);
    L65:
        Api26Impl.setBadgeIconType(this.mBuilder, r13.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, r13.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, r13.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, r13.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, r13.mGroupAlertBehavior);
        if (r13.mColorizedSet == false) goto L69;
        Api26Impl.setColorized(this.mBuilder, r13.mColorized);
    L69:
        if (TextUtils.isEmpty(r13.mChannelId) == true) goto L71;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L71:
        Iterator<Person> r36 = r13.mPersonList.iterator();
    L73:
        if (r36.hasNext() == false) goto L75;
        Api28Impl.addPerson(this.mBuilder, r36.next().toAndroidPerson());
        goto L73
    L75:
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, r13.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(r13.mBubbleMetadata));
        LocusIdCompat r37 = r13.mLocusId;
        if (r37 == null) goto L78;
        Api29Impl.setLocusId(this.mBuilder, r37.toLocusId());
    L78:
        int r38 = r13.mFgsDeferBehavior;
        if (r38 == 0) goto L82;
        Api31Impl.setForegroundServiceBehavior(this.mBuilder, r38);
    L82:
        if (r13.mSilent == true) goto L84;
        return;
    L84:
        if (this.mBuilderCompat.mGroupSummary == false) goto L86;
        this.mGroupAlertBehavior = 2;
    L87:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        int r110 = r11.defaults & (-4);
        r11.defaults = r110;
        this.mBuilder.setDefaults(r110);
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L90;
        Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
    L90:
        Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        return;
    L86:
        this.mGroupAlertBehavior = 1;
        goto L87
    L38:
        if (r27.isEmpty() == true) goto L43;
        Iterator<String> r39 = r27.iterator();
    L41:
        if (r39.hasNext() == false) goto L43;
        Api21Impl.addPerson(this.mBuilder, r39.next());
        goto L41
    L28:
        Iterator<NotificationCompat.Action> r40 = r13.mActions.iterator();
    L30:
        if (r40.hasNext() == false) goto L32;
        addAction(r40.next());
        goto L30
    L21:
        r23 = r22.toIcon(r5);
        goto L22
    L17:
        r21 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r16 = false;
        goto L10
    L5:
        r14 = false;
        goto L6
    }

    private void addAction(NotificationCompat.Action r10) {
        IconCompat r5 = r10.getIconCompat();
        if (r5 == null) goto L5;
        Icon r11 = r5.toIcon();
    L6:
        Notification.Action.Builder r12 = Api23Impl.createBuilder(r11, r10.getTitle(), r10.getActionIntent());
        if (r10.getRemoteInputs() == null) goto L12;
        android.app.RemoteInput[] r13 = RemoteInput.fromCompat(r10.getRemoteInputs());
        int r14 = r13.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L12;
        Api20Impl.addRemoteInput(r12, r13[r15]);
        r15 = r15 + 1;
    L12:
        if (r10.getExtras() == null) goto L14;
        Bundle r16 = new Bundle(r10.getExtras());
    L15:
        r16.putBoolean("android.support.allowGeneratedReplies", r10.getAllowGeneratedReplies());
        Api24Impl.setAllowGeneratedReplies(r12, r10.getAllowGeneratedReplies());
        r16.putInt("android.support.action.semanticAction", r10.getSemanticAction());
        Api28Impl.setSemanticAction(r12, r10.getSemanticAction());
        Api29Impl.setContextual(r12, r10.isContextual());
        Api31Impl.setAuthenticationRequired(r12, r10.isAuthenticationRequired());
        r16.putBoolean("android.support.action.showsUserInterface", r10.getShowsUserInterface());
        Api20Impl.addExtras(r12, r16);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(r12));
        return;
    L14:
        r16 = new Bundle();
        goto L15
    L5:
        r11 = null;
        goto L6
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> r5, @Nullable List<String> r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r10 != null) goto L6;
        return r5;
    L6:
        int r11 = r5.size();
        ArraySet r12 = new ArraySet(r10.size() + r11);
        r12.addAll(r5);
        r12.addAll(r10);
        return new ArrayList(r12);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<Person> r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add(r11.next().resolveToLegacyUri());
        goto L7
    L9:
        return r10;
    }

    private void removeSoundAndVibration(Notification r5) {
        r5.sound = null;
        r5.vibrate = null;
        r5.defaults &= -4;
    }

    public Notification build() {
        NotificationCompat.Style r5 = this.mBuilderCompat.mStyle;
        if (r5 == null) goto L5;
        r5.apply(this);
    L5:
        if (r5 == null) goto L7;
        RemoteViews r10 = r5.makeContentView(this);
    L8:
        Notification r11 = buildInternal();
        if (r10 == null) goto L11;
        r11.contentView = r10;
    L14:
        if (r5 == null) goto L18;
        RemoteViews r12 = r5.makeBigContentView(this);
        if (r12 == null) goto L18;
        r11.bigContentView = r12;
    L18:
        if (r5 == null) goto L22;
        RemoteViews r13 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r13 == null) goto L22;
        r11.headsUpContentView = r13;
    L22:
        if (r5 == null) goto L26;
        Bundle r14 = NotificationCompat.getExtras(r11);
        if (r14 == null) goto L26;
        r5.addCompatExtras(r14);
    L26:
        return r11;
    L11:
        RemoteViews r15 = this.mBuilderCompat.mContentView;
        if (r15 == null) goto L14;
        r11.contentView = r15;
        goto L14
    L7:
        r10 = null;
        goto L8
    }

    public Notification buildInternal() {
        return this.mBuilder.build();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    public Context getContext() {
        return this.mContext;
    }
}
