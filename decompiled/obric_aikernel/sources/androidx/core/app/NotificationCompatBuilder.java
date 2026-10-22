package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Notification build(Notification.Builder r10) {
            return r10.build();
        }

        @DoNotInline
        static Notification.Builder setPriority(Notification.Builder r10, int r11) {
            return r10.setPriority(r11);
        }

        @DoNotInline
        static Notification.Builder setSubText(Notification.Builder r10, CharSequence r11) {
            return r10.setSubText(r11);
        }

        @DoNotInline
        static Notification.Builder setUsesChronometer(Notification.Builder r10, boolean r11) {
            return r10.setUsesChronometer(r11);
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Notification.Builder setShowWhen(Notification.Builder r10, boolean r11) {
            return r10.setShowWhen(r11);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static Notification.Builder setExtras(Notification.Builder r10, Bundle r11) {
            return r10.setExtras(r11);
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static Notification.Builder addAction(Notification.Builder r10, Notification.Action r11) {
            return r10.addAction(r11);
        }

        @DoNotInline
        static Notification.Action.Builder addExtras(Notification.Action.Builder r10, Bundle r11) {
            return r10.addExtras(r11);
        }

        @DoNotInline
        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r10, android.app.RemoteInput r11) {
            return r10.addRemoteInput(r11);
        }

        @DoNotInline
        static Notification.Action build(Notification.Action.Builder r10) {
            return r10.build();
        }

        @DoNotInline
        static Notification.Action.Builder createBuilder(int r10, CharSequence r11, PendingIntent r12) {
            return new Notification.Action.Builder(r10, r11, r12);
        }

        @DoNotInline
        static String getGroup(Notification r10) {
            return r10.getGroup();
        }

        @DoNotInline
        static Notification.Builder setGroup(Notification.Builder r10, String r11) {
            return r10.setGroup(r11);
        }

        @DoNotInline
        static Notification.Builder setGroupSummary(Notification.Builder r10, boolean r11) {
            return r10.setGroupSummary(r11);
        }

        @DoNotInline
        static Notification.Builder setLocalOnly(Notification.Builder r10, boolean r11) {
            return r10.setLocalOnly(r11);
        }

        @DoNotInline
        static Notification.Builder setSortKey(Notification.Builder r10, String r11) {
            return r10.setSortKey(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder r10, String r11) {
            return r10.addPerson(r11);
        }

        @DoNotInline
        static Notification.Builder setCategory(Notification.Builder r10, String r11) {
            return r10.setCategory(r11);
        }

        @DoNotInline
        static Notification.Builder setColor(Notification.Builder r10, int r11) {
            return r10.setColor(r11);
        }

        @DoNotInline
        static Notification.Builder setPublicVersion(Notification.Builder r10, Notification r11) {
            return r10.setPublicVersion(r11);
        }

        @DoNotInline
        static Notification.Builder setSound(Notification.Builder r10, Uri r11, Object r12) {
            return r10.setSound(r11, (AudioAttributes) r12);
        }

        @DoNotInline
        static Notification.Builder setVisibility(Notification.Builder r10, int r11) {
            return r10.setVisibility(r11);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder createBuilder(Icon r10, CharSequence r11, PendingIntent r12) {
            return new Notification.Action.Builder(r10, r11, r12);
        }

        @DoNotInline
        static Notification.Builder setSmallIcon(Notification.Builder r10, Object r11) {
            return r10.setSmallIcon((Icon) r11);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r10, boolean r11) {
            return r10.setAllowGeneratedReplies(r11);
        }

        @DoNotInline
        static Notification.Builder setCustomBigContentView(Notification.Builder r10, RemoteViews r11) {
            return r10.setCustomBigContentView(r11);
        }

        @DoNotInline
        static Notification.Builder setCustomContentView(Notification.Builder r10, RemoteViews r11) {
            return r10.setCustomContentView(r11);
        }

        @DoNotInline
        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder r10, RemoteViews r11) {
            return r10.setCustomHeadsUpContentView(r11);
        }

        @DoNotInline
        static Notification.Builder setRemoteInputHistory(Notification.Builder r10, CharSequence[] r11) {
            return r10.setRemoteInputHistory(r11);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Notification.Builder createBuilder(Context r10, String r11) {
            return new Notification.Builder(r10, r11);
        }

        @DoNotInline
        static Notification.Builder setBadgeIconType(Notification.Builder r10, int r11) {
            return r10.setBadgeIconType(r11);
        }

        @DoNotInline
        static Notification.Builder setColorized(Notification.Builder r10, boolean r11) {
            return r10.setColorized(r11);
        }

        @DoNotInline
        static Notification.Builder setGroupAlertBehavior(Notification.Builder r10, int r11) {
            return r10.setGroupAlertBehavior(r11);
        }

        @DoNotInline
        static Notification.Builder setSettingsText(Notification.Builder r10, CharSequence r11) {
            return r10.setSettingsText(r11);
        }

        @DoNotInline
        static Notification.Builder setShortcutId(Notification.Builder r10, String r11) {
            return r10.setShortcutId(r11);
        }

        @DoNotInline
        static Notification.Builder setTimeoutAfter(Notification.Builder r10, long r11) {
            return r10.setTimeoutAfter(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder r10, android.app.Person r11) {
            return r10.addPerson(r11);
        }

        @DoNotInline
        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder r10, int r11) {
            return r10.setSemanticAction(r11);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder r10, boolean r11) {
            return r10.setAllowSystemGeneratedContextualActions(r11);
        }

        @DoNotInline
        static Notification.Builder setBubbleMetadata(Notification.Builder r10, Notification.BubbleMetadata r11) {
            return r10.setBubbleMetadata(r11);
        }

        @DoNotInline
        static Notification.Action.Builder setContextual(Notification.Action.Builder r10, boolean r11) {
            return r10.setContextual(r11);
        }

        @DoNotInline
        static Notification.Builder setLocusId(Notification.Builder r10, Object r11) {
            return r10.setLocusId((LocusId) r11);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r10, boolean r11) {
            return r10.setAuthenticationRequired(r11);
        }

        @DoNotInline
        static Notification.Builder setForegroundServiceBehavior(Notification.Builder r10, int r11) {
            return r10.setForegroundServiceBehavior(r11);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder r14) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r14;
        Context r10 = r14.mContext;
        this.mContext = r10;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L5;
        Notification.Builder r12 = Api26Impl.createBuilder(r10, r14.mChannelId);
    L6:
        this.mBuilder = r12;
        Notification r13 = r14.mNotification;
        Notification.Builder r15 = this.mBuilder.setWhen(r13.when).setSmallIcon(r13.icon, r13.iconLevel).setContent(r13.contentView).setTicker(r13.tickerText, r14.mTickerView).setVibrate(r13.vibrate).setLights(r13.ledARGB, r13.ledOnMS, r13.ledOffMS);
        if ((r13.flags & 2) == 0) goto L9;
        boolean r16 = true;
    L10:
        Notification.Builder r17 = r15.setOngoing(r16);
        if ((r13.flags & 8) == 0) goto L13;
        boolean r18 = true;
    L14:
        Notification.Builder r19 = r17.setOnlyAlertOnce(r18);
        if ((r13.flags & 16) == 0) goto L17;
        boolean r20 = true;
    L18:
        Notification.Builder r21 = r19.setAutoCancel(r20).setDefaults(r13.defaults).setContentTitle(r14.mContentTitle).setContentText(r14.mContentText).setContentInfo(r14.mContentInfo).setContentIntent(r14.mContentIntent).setDeleteIntent(r13.deleteIntent);
        PendingIntent r22 = r14.mFullScreenIntent;
        if ((r13.flags & 128) == 0) goto L21;
        boolean r23 = true;
    L22:
        r21.setFullScreenIntent(r22, r23).setLargeIcon(r14.mLargeIcon).setNumber(r14.mNumber).setProgress(r14.mProgressMax, r14.mProgress, r14.mProgressIndeterminate);
        if (r11 >= 21) goto L26;
        this.mBuilder.setSound(r13.sound, r13.audioStreamType);
    L26:
        if (r11 < 16) goto L50;
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(this.mBuilder, r14.mSubText), r14.mUseChronometer), r14.mPriority);
        Iterator<NotificationCompat.Action> r24 = r14.mActions.iterator();
    L29:
        if (r24.hasNext() == false) goto L31;
        addAction(r24.next());
        goto L29
    L31:
        Bundle r25 = r14.mExtras;
        if (r25 == null) goto L35;
        this.mExtras.putAll(r25);
    L35:
        if (Build.VERSION.SDK_INT < 20) goto L37;
    L49:
        this.mContentView = r14.mContentView;
        this.mBigContentView = r14.mBigContentView;
        goto L50
    L37:
        if (r14.mLocalOnly == false) goto L39;
        this.mExtras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
    L39:
        String r26 = r14.mGroupKey;
        if (r26 == null) goto L46;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, r26);
        if (r14.mGroupSummary == false) goto L44;
        Bundle r27 = this.mExtras;
        String r28 = NotificationCompatExtras.EXTRA_GROUP_SUMMARY;
    L45:
        r27.putBoolean(r28, true);
        goto L46
    L44:
        r27 = this.mExtras;
        r28 = NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL;
    L46:
        String r29 = r14.mSortKey;
        if (r29 == null) goto L49;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_SORT_KEY, r29);
    L50:
        int r30 = Build.VERSION.SDK_INT;
        if (r30 < 17) goto L54;
        Api17Impl.setShowWhen(this.mBuilder, r14.mShowWhen);
    L54:
        if (r30 < 19) goto L61;
        if (r30 >= 21) goto L61;
        List<String> r31 = combineLists(getPeople(r14.mPersonList), r14.mPeople);
        if (r31 == null) goto L61;
        if (r31.isEmpty() == true) goto L61;
        this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) r31.toArray(new String[r31.size()]));
    L61:
        if (r30 < 20) goto L64;
        Api20Impl.setLocalOnly(this.mBuilder, r14.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, r14.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, r14.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, r14.mGroupSummary);
        this.mGroupAlertBehavior = r14.mGroupAlertBehavior;
    L64:
        if (r30 < 21) goto L86;
        Api21Impl.setCategory(this.mBuilder, r14.mCategory);
        Api21Impl.setColor(this.mBuilder, r14.mColor);
        Api21Impl.setVisibility(this.mBuilder, r14.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, r14.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, r13.sound, r13.audioAttributes);
        if (r30 >= 28) goto L68;
        List r32 = combineLists(getPeople(r14.mPersonList), r14.mPeople);
    L69:
        if (r32 != null) goto L71;
    L76:
        this.mHeadsUpContentView = r14.mHeadsUpContentView;
        if (r14.mInvisibleActions.size() <= 0) goto L86;
        Bundle r33 = r14.getExtras().getBundle("android.car.EXTENSIONS");
        if (r33 != null) goto L81;
        r33 = new Bundle();
    L81:
        Bundle r34 = new Bundle(r33);
        Bundle r35 = new Bundle();
        int r110 = 0;
    L83:
        if (r110 >= r14.mInvisibleActions.size()) goto L85;
        r35.putBundle(Integer.toString(r110), NotificationCompatJellybean.getBundleForAction(r14.mInvisibleActions.get(r110)));
        r110 = r110 + 1;
        goto L83
    L85:
        r33.putBundle("invisible_actions", r35);
        r34.putBundle("invisible_actions", r35);
        r14.getExtras().putBundle("android.car.EXTENSIONS", r33);
        this.mExtras.putBundle("android.car.EXTENSIONS", r34);
        goto L86
    L71:
        if (r32.isEmpty() == true) goto L76;
        Iterator r36 = r32.iterator();
    L74:
        if (r36.hasNext() == false) goto L76;
        Api21Impl.addPerson(this.mBuilder, (String) r36.next());
        goto L74
    L68:
        r32 = r14.mPeople;
    L86:
        int r37 = Build.VERSION.SDK_INT;
        if (r37 < 23) goto L92;
        Object r38 = r14.mSmallIcon;
        if (r38 == null) goto L92;
        Api23Impl.setSmallIcon(this.mBuilder, r38);
    L92:
        if (r37 < 24) goto L103;
        Api19Impl.setExtras(this.mBuilder, r14.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, r14.mRemoteInputHistory);
        RemoteViews r39 = r14.mContentView;
        if (r39 == null) goto L96;
        Api24Impl.setCustomContentView(this.mBuilder, r39);
    L96:
        RemoteViews r40 = r14.mBigContentView;
        if (r40 == null) goto L99;
        Api24Impl.setCustomBigContentView(this.mBuilder, r40);
    L99:
        RemoteViews r41 = r14.mHeadsUpContentView;
        if (r41 == null) goto L103;
        Api24Impl.setCustomHeadsUpContentView(this.mBuilder, r41);
    L103:
        if (r37 < 26) goto L110;
        Api26Impl.setBadgeIconType(this.mBuilder, r14.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, r14.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, r14.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, r14.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, r14.mGroupAlertBehavior);
        if (r14.mColorizedSet == false) goto L108;
        Api26Impl.setColorized(this.mBuilder, r14.mColorized);
    L108:
        if (TextUtils.isEmpty(r14.mChannelId) == true) goto L110;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L110:
        if (r37 < 28) goto L115;
        Iterator<Person> r42 = r14.mPersonList.iterator();
    L113:
        if (r42.hasNext() == false) goto L115;
        Api28Impl.addPerson(this.mBuilder, r42.next().toAndroidPerson());
    L115:
        int r43 = Build.VERSION.SDK_INT;
        if (r43 < 29) goto L121;
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, r14.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(r14.mBubbleMetadata));
        LocusIdCompat r44 = r14.mLocusId;
        if (r44 == null) goto L121;
        Api29Impl.setLocusId(this.mBuilder, r44.toLocusId());
    L121:
        if (r43 < 31) goto L126;
        int r45 = r14.mFgsDeferBehavior;
        if (r45 == 0) goto L126;
        Api31Impl.setForegroundServiceBehavior(this.mBuilder, r45);
    L126:
        if (r14.mSilent == true) goto L128;
        return;
    L128:
        if (this.mBuilderCompat.mGroupSummary == false) goto L130;
        this.mGroupAlertBehavior = 2;
    L131:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        int r111 = r13.defaults & (-2);
        r13.defaults = r111;
        int r112 = r111 & (-3);
        r13.defaults = r112;
        this.mBuilder.setDefaults(r112);
        if (r43 >= 26) goto L134;
        return;
    L134:
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L136;
        Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
    L136:
        Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        return;
    L130:
        this.mGroupAlertBehavior = 1;
        goto L131
    L21:
        r23 = false;
        goto L22
    L17:
        r20 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r16 = false;
        goto L10
    L5:
        r12 = new Notification.Builder(r14.mContext);
        goto L6
    }

    private void addAction(NotificationCompat.Action r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 20) goto L37;
        IconCompat r12 = r10.getIconCompat();
        int r13 = 0;
        if (r11 < 23) goto L10;
        if (r12 == null) goto L8;
        Icon r14 = r12.toIcon();
    L9:
        Notification.Action.Builder r15 = Api23Impl.createBuilder(r14, r10.getTitle(), r10.getActionIntent());
    L15:
        if (r10.getRemoteInputs() == null) goto L20;
        android.app.RemoteInput[] r16 = RemoteInput.fromCompat(r10.getRemoteInputs());
        int r17 = r16.length;
    L17:
        if (r13 >= r17) goto L20;
        Api20Impl.addRemoteInput(r15, r16[r13]);
        r13 = r13 + 1;
    L20:
        if (r10.getExtras() == null) goto L22;
        Bundle r18 = new Bundle(r10.getExtras());
    L23:
        r18.putBoolean("android.support.allowGeneratedReplies", r10.getAllowGeneratedReplies());
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 24) goto L26;
        Api24Impl.setAllowGeneratedReplies(r15, r10.getAllowGeneratedReplies());
    L26:
        r18.putInt("android.support.action.semanticAction", r10.getSemanticAction());
        if (r19 < 28) goto L30;
        Api28Impl.setSemanticAction(r15, r10.getSemanticAction());
    L30:
        if (r19 < 29) goto L33;
        Api29Impl.setContextual(r15, r10.isContextual());
    L33:
        if (r19 < 31) goto L35;
        Api31Impl.setAuthenticationRequired(r15, r10.isAuthenticationRequired());
    L35:
        r18.putBoolean("android.support.action.showsUserInterface", r10.getShowsUserInterface());
        Api20Impl.addExtras(r15, r18);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(r15));
        return;
    L22:
        r18 = new Bundle();
        goto L23
    L8:
        r14 = null;
        goto L9
    L10:
        if (r12 == null) goto L12;
        int r20 = r12.getResId();
    L13:
        r15 = Api20Impl.createBuilder(r20, r10.getTitle(), r10.getActionIntent());
        goto L15
    L12:
        r20 = 0;
        goto L13
    L37:
        if (r11 < 16) goto L42;
        this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, r10));
        return;
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> r10, @Nullable List<String> r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L6;
        return r10;
    L6:
        ArraySet r12 = new ArraySet(r10.size() + r11.size());
        r12.addAll(r10);
        r12.addAll(r11);
        return new ArrayList(r12);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<Person> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(r12.next().resolveToLegacyUri());
        goto L7
    L9:
        return r11;
    }

    private void removeSoundAndVibration(Notification r10) {
        r10.sound = null;
        r10.vibrate = null;
        int r11 = r10.defaults & (-2);
        r10.defaults = r11;
        r10.defaults = r11 & (-3);
    }

    public Notification build() {
        NotificationCompat.Style r10 = this.mBuilderCompat.mStyle;
        if (r10 == null) goto L5;
        r10.apply(this);
    L5:
        if (r10 == null) goto L7;
        RemoteViews r11 = r10.makeContentView(this);
    L8:
        Notification r12 = buildInternal();
        if (r11 == null) goto L11;
    L10:
        r12.contentView = r11;
    L14:
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 16) goto L21;
        if (r10 == null) goto L21;
        RemoteViews r14 = r10.makeBigContentView(this);
        if (r14 == null) goto L21;
        r12.bigContentView = r14;
    L21:
        if (r13 < 21) goto L26;
        if (r10 == null) goto L26;
        RemoteViews r15 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r15 == null) goto L26;
        r12.headsUpContentView = r15;
    L26:
        if (r13 < 16) goto L31;
        if (r10 == null) goto L31;
        Bundle r16 = NotificationCompat.getExtras(r12);
        if (r16 == null) goto L31;
        r10.addCompatExtras(r16);
    L31:
        return r12;
    L11:
        r11 = this.mBuilderCompat.mContentView;
        if (r11 == null) goto L14;
    L7:
        r11 = null;
        goto L8
    }

    protected Notification buildInternal() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 26) goto L7;
        return Api16Impl.build(this.mBuilder);
    L7:
        if (r10 < 24) goto L26;
        Notification r11 = Api16Impl.build(this.mBuilder);
        if (this.mGroupAlertBehavior != 0) goto L11;
    L24:
        return r11;
    L11:
        if (Api20Impl.getGroup(r11) == null) goto L18;
        if ((r11.flags & 512) == 0) goto L18;
        if (this.mGroupAlertBehavior != 2) goto L18;
        removeSoundAndVibration(r11);
    L18:
        if (Api20Impl.getGroup(r11) == null) goto L24;
        if ((r11.flags & 512) != 0) goto L24;
        if (this.mGroupAlertBehavior != 1) goto L24;
        removeSoundAndVibration(r11);
        goto L24
    L26:
        if (r10 < 21) goto L54;
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r12 = Api16Impl.build(this.mBuilder);
        RemoteViews r13 = this.mContentView;
        if (r13 == null) goto L30;
        r12.contentView = r13;
    L30:
        RemoteViews r14 = this.mBigContentView;
        if (r14 == null) goto L33;
        r12.bigContentView = r14;
    L33:
        RemoteViews r15 = this.mHeadsUpContentView;
        if (r15 == null) goto L37;
        r12.headsUpContentView = r15;
    L37:
        if (this.mGroupAlertBehavior != 0) goto L39;
    L52:
        return r12;
    L39:
        if (Api20Impl.getGroup(r12) == null) goto L46;
        if ((r12.flags & 512) == 0) goto L46;
        if (this.mGroupAlertBehavior != 2) goto L46;
        removeSoundAndVibration(r12);
    L46:
        if (Api20Impl.getGroup(r12) == null) goto L52;
        if ((r12.flags & 512) != 0) goto L52;
        if (this.mGroupAlertBehavior != 1) goto L52;
        removeSoundAndVibration(r12);
        goto L52
    L54:
        if (r10 < 20) goto L79;
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r16 = Api16Impl.build(this.mBuilder);
        RemoteViews r17 = this.mContentView;
        if (r17 == null) goto L58;
        r16.contentView = r17;
    L58:
        RemoteViews r18 = this.mBigContentView;
        if (r18 == null) goto L62;
        r16.bigContentView = r18;
    L62:
        if (this.mGroupAlertBehavior != 0) goto L64;
    L77:
        return r16;
    L64:
        if (Api20Impl.getGroup(r16) == null) goto L71;
        if ((r16.flags & 512) == 0) goto L71;
        if (this.mGroupAlertBehavior != 2) goto L71;
        removeSoundAndVibration(r16);
    L71:
        if (Api20Impl.getGroup(r16) == null) goto L77;
        if ((r16.flags & 512) != 0) goto L77;
        if (this.mGroupAlertBehavior != 1) goto L77;
        removeSoundAndVibration(r16);
        goto L77
    L79:
        if (r10 < 19) goto L91;
        SparseArray<Bundle> r19 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r19 == null) goto L83;
        this.mExtras.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r19);
    L83:
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r20 = Api16Impl.build(this.mBuilder);
        RemoteViews r21 = this.mContentView;
        if (r21 == null) goto L86;
        r20.contentView = r21;
    L86:
        RemoteViews r22 = this.mBigContentView;
        if (r22 == null) goto L89;
        r20.bigContentView = r22;
    L89:
        return r20;
    L91:
        if (r10 < 16) goto L109;
        Notification r23 = Api16Impl.build(this.mBuilder);
        Bundle r24 = NotificationCompat.getExtras(r23);
        Bundle r25 = new Bundle(this.mExtras);
        Iterator<String> r26 = this.mExtras.keySet().iterator();
    L94:
        if (r26.hasNext() == false) goto L98;
        String r27 = r26.next();
        if (r24.containsKey(r27) == false) goto L94;
        r25.remove(r27);
        goto L94
    L98:
        r24.putAll(r25);
        SparseArray<Bundle> r28 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r28 == null) goto L101;
        NotificationCompat.getExtras(r23).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r28);
    L101:
        RemoteViews r29 = this.mContentView;
        if (r29 == null) goto L104;
        r23.contentView = r29;
    L104:
        RemoteViews r30 = this.mBigContentView;
        if (r30 == null) goto L107;
        r23.bigContentView = r30;
    L107:
        return r23;
    L109:
        return this.mBuilder.getNotification();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }
}
