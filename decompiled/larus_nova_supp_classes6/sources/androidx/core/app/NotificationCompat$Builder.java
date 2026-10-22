package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NotificationCompat$Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList<NotificationCompat.Action> mActions;
    boolean mAllowSystemGeneratedContextualActions;
    int mBadgeIcon;
    RemoteViews mBigContentView;
    NotificationCompat.BubbleMetadata mBubbleMetadata;
    String mCategory;
    String mChannelId;
    boolean mChronometerCountDown;
    int mColor;
    boolean mColorized;
    boolean mColorizedSet;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    RemoteViews mContentView;
    public Context mContext;
    Bundle mExtras;
    int mFgsDeferBehavior;
    PendingIntent mFullScreenIntent;
    int mGroupAlertBehavior;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    ArrayList<NotificationCompat.Action> mInvisibleActions;
    IconCompat mLargeIcon;
    boolean mLocalOnly;
    LocusIdCompat mLocusId;
    Notification mNotification;
    int mNumber;
    public ArrayList<String> mPeople;
    public ArrayList<Person> mPersonList;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    CharSequence[] mRemoteInputHistory;
    CharSequence mSettingsText;
    String mShortcutId;
    boolean mShowWhen;
    boolean mSilent;
    Object mSmallIcon;
    String mSortKey;
    NotificationCompat$Style mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    long mTimeout;
    boolean mUseChronometer;
    int mVisibility;

    public NotificationCompat$Builder setNotificationSilent() {
        this.mSilent = true;
        return this;
    }

    private boolean useExistingRemoteView() {
        NotificationCompat$Style r0 = this.mStyle;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.displayCustomViewInline() == false) goto L8;
        return false;
    }

    public Notification build() {
        return new NotificationCompatBuilder(this).build();
    }

    public NotificationCompat$Builder clearActions() {
        this.mActions.clear();
        return this;
    }

    public NotificationCompat$Builder clearInvisibleActions() {
        this.mInvisibleActions.clear();
        Bundle r0 = this.mExtras.getBundle("android.car.EXTENSIONS");
        if (r0 == null) goto L5;
        Bundle r2 = new Bundle(r0);
        r2.remove("invisible_actions");
        this.mExtras.putBundle("android.car.EXTENSIONS", r2);
    L5:
        return this;
    }

    public NotificationCompat$Builder clearPeople() {
        this.mPersonList.clear();
        this.mPeople.clear();
        return this;
    }

    public RemoteViews createBigContentView() {
        if (this.mBigContentView != null) goto L5;
    L8:
        NotificationBuilderWithBuilderAccessor r0 = new NotificationCompatBuilder(this);
        NotificationCompat$Style r1 = this.mStyle;
        if (r1 == null) goto L13;
        RemoteViews r2 = r1.makeBigContentView(r0);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Notification r3 = r0.build();
        if (Build.VERSION.SDK_INT < 24) goto L18;
        return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, r3));
    L18:
        return r3.bigContentView;
    L5:
        if (useExistingRemoteView() == false) goto L8;
        return this.mBigContentView;
    }

    public RemoteViews createContentView() {
        if (this.mContentView != null) goto L5;
    L8:
        NotificationBuilderWithBuilderAccessor r0 = new NotificationCompatBuilder(this);
        NotificationCompat$Style r1 = this.mStyle;
        if (r1 == null) goto L13;
        RemoteViews r2 = r1.makeContentView(r0);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Notification r3 = r0.build();
        if (Build.VERSION.SDK_INT < 24) goto L18;
        return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, r3));
    L18:
        return r3.contentView;
    L5:
        if (useExistingRemoteView() == false) goto L8;
        return this.mContentView;
    }

    public RemoteViews createHeadsUpContentView() {
        int r0 = Build.VERSION.SDK_INT;
        if (this.mHeadsUpContentView != null) goto L5;
    L8:
        NotificationBuilderWithBuilderAccessor r1 = new NotificationCompatBuilder(this);
        NotificationCompat$Style r2 = this.mStyle;
        if (r2 == null) goto L13;
        RemoteViews r3 = r2.makeHeadsUpContentView(r1);
        if (r3 == null) goto L13;
        return r3;
    L13:
        Notification r4 = r1.build();
        if (r0 < 24) goto L18;
        return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, r4));
    L18:
        return r4.headsUpContentView;
    L5:
        if (useExistingRemoteView() == false) goto L8;
        return this.mHeadsUpContentView;
    }

    public Bundle getExtras() {
        if (this.mExtras != null) goto L6;
        this.mExtras = new Bundle();
    L6:
        return this.mExtras;
    }

    public long getWhenIfShowing() {
        if (this.mShowWhen == true) goto L7;
        return 0;
    L7:
        return this.mNotification.when;
    }

    public Notification getNotification() {
        return build();
    }

    public RemoteViews getBigContentView() {
        return this.mBigContentView;
    }

    public NotificationCompat.BubbleMetadata getBubbleMetadata() {
        return this.mBubbleMetadata;
    }

    public int getColor() {
        return this.mColor;
    }

    public RemoteViews getContentView() {
        return this.mContentView;
    }

    public int getForegroundServiceBehavior() {
        return this.mFgsDeferBehavior;
    }

    public RemoteViews getHeadsUpContentView() {
        return this.mHeadsUpContentView;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public NotificationCompat$Builder(Context r2) {
        this(r2, null);
    }

    public static CharSequence limitCharSequenceLength(CharSequence r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.length() > MAX_CHARSEQUENCE_LENGTH) goto L7;
        return r2;
    L7:
        return r2.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
    }

    public NotificationCompat$Builder addAction(NotificationCompat.Action r2) {
        if (r2 == null) goto L4;
        this.mActions.add(r2);
    L4:
        return this;
    }

    public NotificationCompat$Builder addExtras(Bundle r2) {
        if (r2 == null) goto L7;
        Bundle r0 = this.mExtras;
        if (r0 != null) goto L6;
        this.mExtras = new Bundle(r2);
        goto L7
    L6:
        r0.putAll(r2);
    L7:
        return this;
    }

    public NotificationCompat$Builder addInvisibleAction(NotificationCompat.Action r2) {
        if (r2 == null) goto L4;
        this.mInvisibleActions.add(r2);
    L4:
        return this;
    }

    public NotificationCompat$Builder addPerson(String r2) {
        if (r2 != null) goto L4;
    L6:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L6;
        this.mPeople.add(r2);
        goto L6
    }

    public NotificationCompat$Builder extend(NotificationCompat.Extender r1) {
        r1.extend(this);
        return this;
    }

    public NotificationCompat$Builder setAllowSystemGeneratedContextualActions(boolean r1) {
        this.mAllowSystemGeneratedContextualActions = r1;
        return this;
    }

    public NotificationCompat$Builder setAutoCancel(boolean r2) {
        setFlag(16, r2);
        return this;
    }

    public NotificationCompat$Builder setBadgeIconType(int r1) {
        this.mBadgeIcon = r1;
        return this;
    }

    public NotificationCompat$Builder setBubbleMetadata(NotificationCompat.BubbleMetadata r1) {
        this.mBubbleMetadata = r1;
        return this;
    }

    public NotificationCompat$Builder setCategory(String r1) {
        this.mCategory = r1;
        return this;
    }

    public NotificationCompat$Builder setChannelId(String r1) {
        this.mChannelId = r1;
        return this;
    }

    public NotificationCompat$Builder setChronometerCountDown(boolean r3) {
        this.mChronometerCountDown = r3;
        getExtras().putBoolean("android.chronometerCountDown", r3);
        return this;
    }

    public NotificationCompat$Builder setColor(int r1) {
        this.mColor = r1;
        return this;
    }

    public NotificationCompat$Builder setColorized(boolean r1) {
        this.mColorized = r1;
        this.mColorizedSet = true;
        return this;
    }

    public NotificationCompat$Builder setContent(RemoteViews r2) {
        this.mNotification.contentView = r2;
        return this;
    }

    public NotificationCompat$Builder setContentInfo(CharSequence r1) {
        this.mContentInfo = limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$Builder setContentIntent(PendingIntent r1) {
        this.mContentIntent = r1;
        return this;
    }

    public NotificationCompat$Builder setContentText(CharSequence r1) {
        this.mContentText = limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$Builder setContentTitle(CharSequence r1) {
        this.mContentTitle = limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$Builder setCustomBigContentView(RemoteViews r1) {
        this.mBigContentView = r1;
        return this;
    }

    public NotificationCompat$Builder setCustomContentView(RemoteViews r1) {
        this.mContentView = r1;
        return this;
    }

    public NotificationCompat$Builder setCustomHeadsUpContentView(RemoteViews r1) {
        this.mHeadsUpContentView = r1;
        return this;
    }

    public NotificationCompat$Builder setDefaults(int r2) {
        Notification r0 = this.mNotification;
        r0.defaults = r2;
        if ((r2 & 4) == 0) goto L5;
        r0.flags |= 1;
    L5:
        return this;
    }

    public NotificationCompat$Builder setDeleteIntent(PendingIntent r2) {
        this.mNotification.deleteIntent = r2;
        return this;
    }

    public NotificationCompat$Builder setExtras(Bundle r1) {
        this.mExtras = r1;
        return this;
    }

    public NotificationCompat$Builder setForegroundServiceBehavior(int r1) {
        this.mFgsDeferBehavior = r1;
        return this;
    }

    public NotificationCompat$Builder setGroup(String r1) {
        this.mGroupKey = r1;
        return this;
    }

    public NotificationCompat$Builder setGroupAlertBehavior(int r1) {
        this.mGroupAlertBehavior = r1;
        return this;
    }

    public NotificationCompat$Builder setGroupSummary(boolean r1) {
        this.mGroupSummary = r1;
        return this;
    }

    public NotificationCompat$Builder setLargeIcon(Bitmap r2) {
        if (r2 != null) goto L4;
        IconCompat r3 = null;
    L5:
        this.mLargeIcon = r3;
        return this;
    L4:
        r3 = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, r2));
        goto L5
    }

    public NotificationCompat$Builder setLocalOnly(boolean r1) {
        this.mLocalOnly = r1;
        return this;
    }

    public NotificationCompat$Builder setLocusId(LocusIdCompat r1) {
        this.mLocusId = r1;
        return this;
    }

    public NotificationCompat$Builder setNumber(int r1) {
        this.mNumber = r1;
        return this;
    }

    public NotificationCompat$Builder setOngoing(boolean r2) {
        setFlag(2, r2);
        return this;
    }

    public NotificationCompat$Builder setOnlyAlertOnce(boolean r2) {
        setFlag(8, r2);
        return this;
    }

    public NotificationCompat$Builder setPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    public NotificationCompat$Builder setPublicVersion(Notification r1) {
        this.mPublicVersion = r1;
        return this;
    }

    public NotificationCompat$Builder setRemoteInputHistory(CharSequence[] r1) {
        this.mRemoteInputHistory = r1;
        return this;
    }

    public NotificationCompat$Builder setSettingsText(CharSequence r1) {
        this.mSettingsText = limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$Builder setShortcutId(String r1) {
        this.mShortcutId = r1;
        return this;
    }

    public NotificationCompat$Builder setShortcutInfo(ShortcutInfoCompat r3) {
        if (r3 != null) goto L4;
        return this;
    L4:
        this.mShortcutId = r3.getId();
        if (this.mLocusId != null) goto L13;
        if (r3.getLocusId() == null) goto L10;
        this.mLocusId = r3.getLocusId();
        goto L13
    L10:
        if (r3.getId() == null) goto L13;
        this.mLocusId = new LocusIdCompat(r3.getId());
    L13:
        if (this.mContentTitle != null) goto L15;
        setContentTitle(r3.getShortLabel());
    L15:
        return this;
    }

    public NotificationCompat$Builder setShowWhen(boolean r1) {
        this.mShowWhen = r1;
        return this;
    }

    public NotificationCompat$Builder setSilent(boolean r1) {
        this.mSilent = r1;
        return this;
    }

    public NotificationCompat$Builder setSmallIcon(IconCompat r2) {
        this.mSmallIcon = r2.toIcon(this.mContext);
        return this;
    }

    public NotificationCompat$Builder setSortKey(String r1) {
        this.mSortKey = r1;
        return this;
    }

    public NotificationCompat$Builder setSound(Uri r2) {
        Notification r0 = this.mNotification;
        r0.sound = r2;
        r0.audioStreamType = -1;
        AudioAttributes.Builder r3 = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
        Notification r1 = this.mNotification;
        r1.audioAttributes = Api21Impl.build(r3);
        return this;
    }

    public NotificationCompat$Builder setStyle(NotificationCompat$Style r2) {
        if (this.mStyle == r2) goto L7;
        this.mStyle = r2;
        if (r2 == null) goto L7;
        r2.setBuilder(this);
    L7:
        return this;
    }

    public NotificationCompat$Builder setSubText(CharSequence r1) {
        this.mSubText = limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$Builder setTicker(CharSequence r2) {
        Notification r0 = this.mNotification;
        r0.tickerText = limitCharSequenceLength(r2);
        return this;
    }

    public NotificationCompat$Builder setTimeoutAfter(long r1) {
        this.mTimeout = r1;
        return this;
    }

    public NotificationCompat$Builder setUsesChronometer(boolean r1) {
        this.mUseChronometer = r1;
        return this;
    }

    public NotificationCompat$Builder setVibrate(long[] r2) {
        this.mNotification.vibrate = r2;
        return this;
    }

    public NotificationCompat$Builder setVisibility(int r1) {
        this.mVisibility = r1;
        return this;
    }

    public NotificationCompat$Builder setWhen(long r2) {
        this.mNotification.when = r2;
        return this;
    }

    public NotificationCompat$Builder addPerson(Person r2) {
        if (r2 == null) goto L4;
        this.mPersonList.add(r2);
    L4:
        return this;
    }

    public NotificationCompat$Builder setLargeIcon(Icon r1) {
        if (r1 != null) goto L4;
        IconCompat r2 = null;
    L5:
        this.mLargeIcon = r2;
        return this;
    L4:
        r2 = IconCompat.createFromIcon(r1);
        goto L5
    }

    public NotificationCompat$Builder setSmallIcon(int r2) {
        this.mNotification.icon = r2;
        return this;
    }

    public NotificationCompat$Builder(Context r6, Notification r7) {
        this(r6, NotificationCompat.getChannelId(r7));
        Bundle r8 = r7.extras;
        NotificationCompat$Style r0 = NotificationCompat$Style.extractStyleFromNotification(r7);
        setContentTitle(NotificationCompat.getContentTitle(r7)).setContentText(NotificationCompat.getContentText(r7)).setContentInfo(NotificationCompat.getContentInfo(r7)).setSubText(NotificationCompat.getSubText(r7)).setSettingsText(NotificationCompat.getSettingsText(r7)).setStyle(r0).setGroup(NotificationCompat.getGroup(r7)).setGroupSummary(NotificationCompat.isGroupSummary(r7)).setLocusId(NotificationCompat.getLocusId(r7)).setWhen(r7.when).setShowWhen(NotificationCompat.getShowWhen(r7)).setUsesChronometer(NotificationCompat.getUsesChronometer(r7)).setAutoCancel(NotificationCompat.getAutoCancel(r7)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r7)).setOngoing(NotificationCompat.getOngoing(r7)).setLocalOnly(NotificationCompat.getLocalOnly(r7)).setLargeIcon(r7.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r7)).setCategory(NotificationCompat.getCategory(r7)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r7)).setNumber(r7.number).setTicker(r7.tickerText).setContentIntent(r7.contentIntent).setDeleteIntent(r7.deleteIntent).setFullScreenIntent(r7.fullScreenIntent, NotificationCompat.getHighPriority(r7)).setSound(r7.sound, r7.audioStreamType).setVibrate(r7.vibrate).setLights(r7.ledARGB, r7.ledOnMS, r7.ledOffMS).setDefaults(r7.defaults).setPriority(r7.priority).setColor(NotificationCompat.getColor(r7)).setVisibility(NotificationCompat.getVisibility(r7)).setPublicVersion(NotificationCompat.getPublicVersion(r7)).setSortKey(NotificationCompat.getSortKey(r7)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r7)).setShortcutId(NotificationCompat.getShortcutId(r7)).setProgress(r8.getInt("android.progressMax"), r8.getInt("android.progress"), r8.getBoolean("android.progressIndeterminate")).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r7)).setSmallIcon(r7.icon, r7.iconLevel).addExtras(getExtrasWithoutDuplicateData(r7, r0));
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mSmallIcon = Api23Impl.getSmallIcon(r7);
        Icon r1 = Api23Impl.getLargeIcon(r7);
        if (r1 == null) goto L7;
        this.mLargeIcon = IconCompat.createFromIcon(r1);
    L7:
        Notification.Action[] r2 = r7.actions;
        int r3 = 0;
        if (r2 != null) goto L10;
    L14:
        List r4 = NotificationCompat.getInvisibleActions(r7);
        if (r4.isEmpty() == true) goto L20;
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        addInvisibleAction((NotificationCompat.Action) r5.next());
    L20:
        String[] r9 = r7.extras.getStringArray("android.people");
        if (r9 == null) goto L28;
        if (r9.length == 0) goto L28;
        int r10 = r9.length;
    L25:
        if (r3 >= r10) goto L28;
        addPerson(r9[r3]);
        r3 = r3 + 1;
    L28:
        if (Build.VERSION.SDK_INT < 28) goto L37;
        ArrayList r11 = r7.extras.getParcelableArrayList("android.people.list");
        if (r11 == null) goto L37;
        if (r11.isEmpty() == true) goto L37;
        Iterator r12 = r11.iterator();
    L35:
        if (r12.hasNext() == false) goto L37;
        addPerson(Person.fromAndroidPerson((android.app.Person) r12.next()));
    L37:
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 24) goto L43;
        if (r8.containsKey("android.chronometerCountDown") == false) goto L43;
        setChronometerCountDown(r8.getBoolean("android.chronometerCountDown"));
    L43:
        if (r13 >= 26) goto L45;
        return;
    L45:
        if (r8.containsKey("android.colorized") == false) goto L53;
        setColorized(r8.getBoolean("android.colorized"));
        return;
    L53:
        return;
    L10:
        if (r2.length == 0) goto L14;
        int r14 = r2.length;
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L14;
        addAction(NotificationCompat.Action.Builder.fromAndroidAction(r2[r15]).build());
        r15 = r15 + 1;
        goto L12
    }

    private static Bundle getExtrasWithoutDuplicateData(Notification r3, NotificationCompat$Style r4) {
        if (r3.extras != null) goto L6;
        return null;
    L6:
        Bundle r0 = new Bundle(r3.extras);
        r0.remove("android.title");
        r0.remove("android.text");
        r0.remove("android.infoText");
        r0.remove("android.subText");
        r0.remove("android.intent.extra.CHANNEL_ID");
        r0.remove("android.intent.extra.CHANNEL_GROUP_ID");
        r0.remove("android.showWhen");
        r0.remove("android.progress");
        r0.remove("android.progressMax");
        r0.remove("android.progressIndeterminate");
        r0.remove("android.chronometerCountDown");
        r0.remove("android.colorized");
        r0.remove("android.people.list");
        r0.remove("android.people");
        r0.remove("android.support.sortKey");
        r0.remove("android.support.groupKey");
        r0.remove("android.support.isGroupSummary");
        r0.remove("android.support.localOnly");
        r0.remove("android.support.actionExtras");
        Bundle r1 = r0.getBundle("android.car.EXTENSIONS");
        if (r1 == null) goto L9;
        Bundle r2 = new Bundle(r1);
        r2.remove("invisible_actions");
        r0.putBundle("android.car.EXTENSIONS", r2);
    L9:
        if (r4 == null) goto L11;
        r4.clearCompatExtraKeys(r0);
    L11:
        return r0;
    }

    private void setFlag(int r2, boolean r3) {
        if (r3 == false) goto L4;
        Notification r4 = this.mNotification;
        r4.flags = r2 | r4.flags;
        return;
    L4:
        Notification r5 = this.mNotification;
        int r0 = r5.flags;
        r5.flags = (~r2) & r0;
    }

    public NotificationCompat$Builder setFullScreenIntent(PendingIntent r1, boolean r2) {
        this.mFullScreenIntent = r1;
        setFlag(128, r2);
        return this;
    }

    public NotificationCompat$Builder setSmallIcon(int r2, int r3) {
        Notification r0 = this.mNotification;
        r0.icon = r2;
        r0.iconLevel = r3;
        return this;
    }

    public NotificationCompat$Builder setSound(Uri r2, int r3) {
        Notification r0 = this.mNotification;
        r0.sound = r2;
        r0.audioStreamType = r3;
        AudioAttributes.Builder r4 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), r3);
        Notification r5 = this.mNotification;
        r5.audioAttributes = Api21Impl.build(r4);
        return this;
    }

    public NotificationCompat$Builder setTicker(CharSequence r2, RemoteViews r3) {
        Notification r0 = this.mNotification;
        r0.tickerText = limitCharSequenceLength(r2);
        this.mTickerView = r3;
        return this;
    }

    public NotificationCompat$Builder(Context r4, String r5) {
        this.mActions = new ArrayList();
        this.mPersonList = new ArrayList();
        this.mInvisibleActions = new ArrayList();
        this.mShowWhen = true;
        this.mLocalOnly = false;
        this.mColor = 0;
        this.mVisibility = 0;
        this.mBadgeIcon = 0;
        this.mGroupAlertBehavior = 0;
        this.mFgsDeferBehavior = 0;
        Notification r2 = new Notification();
        this.mNotification = r2;
        this.mContext = r4;
        this.mChannelId = r5;
        r2.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public NotificationCompat$Builder addAction(int r3, CharSequence r4, PendingIntent r5) {
        this.mActions.add(new NotificationCompat.Action(r3, r4, r5));
        return this;
    }

    public NotificationCompat$Builder addInvisibleAction(int r3, CharSequence r4, PendingIntent r5) {
        this.mInvisibleActions.add(new NotificationCompat.Action(r3, r4, r5));
        return this;
    }

    public NotificationCompat$Builder setLights(int r2, int r3, int r4) {
        Notification r0 = this.mNotification;
        r0.ledARGB = r2;
        r0.ledOnMS = r3;
        r0.ledOffMS = r4;
        if (r3 == 0) goto L6;
        if (r4 == 0) goto L6;
        int r5 = 1;
    L7:
        r0.flags = r5 | (r0.flags & (-2));
        return this;
    L6:
        r5 = 0;
        goto L7
    }

    public NotificationCompat$Builder setProgress(int r1, int r2, boolean r3) {
        this.mProgressMax = r1;
        this.mProgress = r2;
        this.mProgressIndeterminate = r3;
        return this;
    }
}
