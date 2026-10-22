package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

    static class Api16Impl {
        private Api16Impl() {
        }

        static Notification build(Notification.Builder r0) {
            return r0.build();
        }

        static Notification.Builder setPriority(Notification.Builder r0, int r1) {
            return r0.setPriority(r1);
        }

        static Notification.Builder setSubText(Notification.Builder r2, CharSequence r3) {
            return r2.setSubText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static Notification.Builder setUsesChronometer(Notification.Builder r0, boolean r1) {
            return r0.setUsesChronometer(r1);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Notification.Builder setShowWhen(Notification.Builder r0, boolean r1) {
            return r0.setShowWhen(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static Notification.Builder setExtras(Notification.Builder r0, Bundle r1) {
            return r0.setExtras(r1);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Notification.Builder addAction(Notification.Builder r0, Notification.Action r1) {
            return r0.addAction(r1);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder r0, Bundle r1) {
            return r0.addExtras(r1);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r0, android.app.RemoteInput r1) {
            return r0.addRemoteInput(r1);
        }

        static Notification.Action build(Notification.Action.Builder r0) {
            return r0.build();
        }

        static Notification.Action.Builder createBuilder(int r2, CharSequence r3, PendingIntent r4) {
            return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        }

        static String getGroup(Notification r0) {
            return r0.getGroup();
        }

        static Notification.Builder setGroup(Notification.Builder r0, String r1) {
            return r0.setGroup(r1);
        }

        static Notification.Builder setGroupSummary(Notification.Builder r0, boolean r1) {
            return r0.setGroupSummary(r1);
        }

        static Notification.Builder setLocalOnly(Notification.Builder r0, boolean r1) {
            return r0.setLocalOnly(r1);
        }

        static Notification.Builder setSortKey(Notification.Builder r0, String r1) {
            return r0.setSortKey(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder r0, String r1) {
            return r0.addPerson(r1);
        }

        static Notification.Builder setCategory(Notification.Builder r0, String r1) {
            return r0.setCategory(r1);
        }

        static Notification.Builder setColor(Notification.Builder r0, int r1) {
            return r0.setColor(r1);
        }

        static Notification.Builder setPublicVersion(Notification.Builder r0, Notification r1) {
            return r0.setPublicVersion(r1);
        }

        static Notification.Builder setSound(Notification.Builder r2, Uri r3, Object r4) {
            return r2.setSound(r3, (AudioAttributes) ZeusTransformUtils.preCheckCast(r4, AudioAttributes.class, "com.obric.memorydata.plugin"));
        }

        static Notification.Builder setVisibility(Notification.Builder r0, int r1) {
            return r0.setVisibility(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Notification.Action.Builder createBuilder(Icon r2, CharSequence r3, PendingIntent r4) {
            return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        }

        static Notification.Builder setLargeIcon(Notification.Builder r0, Icon r1) {
            return r0.setLargeIcon(r1);
        }

        static Notification.Builder setSmallIcon(Notification.Builder r2, Object r3) {
            return r2.setSmallIcon((Icon) ZeusTransformUtils.preCheckCast(r3, Icon.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r0, boolean r1) {
            return r0.setAllowGeneratedReplies(r1);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomBigContentView(r1);
        }

        static Notification.Builder setCustomContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomContentView(r1);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomHeadsUpContentView(r1);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder r0, CharSequence[] r1) {
            return r0.setRemoteInputHistory(r1);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Notification.Builder createBuilder(Context r2, String r3) {
            return new Notification.Builder((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        }

        static Notification.Builder setBadgeIconType(Notification.Builder r0, int r1) {
            return r0.setBadgeIconType(r1);
        }

        static Notification.Builder setColorized(Notification.Builder r0, boolean r1) {
            return r0.setColorized(r1);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder r0, int r1) {
            return r0.setGroupAlertBehavior(r1);
        }

        static Notification.Builder setSettingsText(Notification.Builder r2, CharSequence r3) {
            return r2.setSettingsText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static Notification.Builder setShortcutId(Notification.Builder r0, String r1) {
            return r0.setShortcutId(r1);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder r0, long r1) {
            return r0.setTimeoutAfter(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder r0, android.app.Person r1) {
            return r0.addPerson(r1);
        }

        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder r0, int r1) {
            return r0.setSemanticAction(r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder r0, boolean r1) {
            return r0.setAllowSystemGeneratedContextualActions(r1);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder r0, Notification.BubbleMetadata r1) {
            return r0.setBubbleMetadata(r1);
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder r0, boolean r1) {
            return r0.setContextual(r1);
        }

        static Notification.Builder setLocusId(Notification.Builder r2, Object r3) {
            return r2.setLocusId((LocusId) ZeusTransformUtils.preCheckCast(r3, LocusId.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r0, boolean r1) {
            return r0.setAuthenticationRequired(r1);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder r0, int r1) {
            return r0.setForegroundServiceBehavior(r1);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder r17) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r17;
        Context r2 = ZeusTransformUtils.wrapperContext(r17.mContext, "com.obric.memorydata.plugin");
        this.mContext = r2;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Notification.Builder r4 = Api26Impl.createBuilder(r17.mContext, r17.mChannelId);
    L6:
        this.mBuilder = r4;
        Notification r5 = r17.mNotification;
        Notification.Builder r6 = this.mBuilder.setWhen(r5.when).setSmallIcon(r5.icon, r5.iconLevel).setContent(r5.contentView).setTicker(r5.tickerText, r17.mTickerView).setVibrate(r5.vibrate).setLights(r5.ledARGB, r5.ledOnMS, r5.ledOffMS);
        if ((r5.flags & 2) == 0) goto L9;
        boolean r7 = true;
    L10:
        Notification.Builder r8 = r6.setOngoing(r7);
        if ((r5.flags & 8) == 0) goto L13;
        boolean r9 = true;
    L14:
        Notification.Builder r10 = r8.setOnlyAlertOnce(r9);
        if ((r5.flags & 16) == 0) goto L17;
        boolean r11 = true;
    L18:
        Notification.Builder r12 = r10.setAutoCancel(r11).setDefaults(r5.defaults).setContentTitle(r17.mContentTitle).setContentText(r17.mContentText).setContentInfo(r17.mContentInfo).setContentIntent(r17.mContentIntent).setDeleteIntent(r5.deleteIntent);
        PendingIntent r13 = r17.mFullScreenIntent;
        if ((r5.flags & 128) == 0) goto L21;
        boolean r14 = true;
    L22:
        r12.setFullScreenIntent(r13, r14).setNumber(r17.mNumber).setProgress(r17.mProgressMax, r17.mProgress, r17.mProgressIndeterminate);
        if (Build.VERSION.SDK_INT >= 23) goto L29;
        Notification.Builder r3 = this.mBuilder;
        if (r17.mLargeIcon != null) goto L27;
        Bitmap r15 = null;
    L28:
        r3.setLargeIcon(r15);
    L35:
        if (Build.VERSION.SDK_INT >= 21) goto L38;
        this.mBuilder.setSound(r5.sound, r5.audioStreamType);
    L38:
        if (Build.VERSION.SDK_INT < 16) goto L71;
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(this.mBuilder, r17.mSubText), r17.mUseChronometer), r17.mPriority);
        if (Build.VERSION.SDK_INT >= 20) goto L42;
    L47:
        Iterator<NotificationCompat.Action> r16 = r17.mActions.iterator();
    L49:
        if (r16.hasNext() == false) goto L52;
        addAction((NotificationCompat.Action) ZeusTransformUtils.preCheckCast(r16.next(), NotificationCompat.Action.class, "com.obric.memorydata.plugin"));
    L52:
        if (r17.mExtras == null) goto L55;
        this.mExtras.putAll(r17.mExtras);
    L55:
        if (Build.VERSION.SDK_INT < 20) goto L57;
    L69:
        this.mContentView = r17.mContentView;
        this.mBigContentView = r17.mBigContentView;
        goto L71
    L57:
        if (r17.mLocalOnly == false) goto L60;
        this.mExtras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
    L60:
        if (r17.mGroupKey == null) goto L67;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, r17.mGroupKey);
        if (r17.mGroupSummary == false) goto L64;
        Bundle r18 = this.mExtras;
        String r19 = NotificationCompatExtras.EXTRA_GROUP_SUMMARY;
    L65:
        r18.putBoolean(r19, true);
        goto L67
    L64:
        r18 = this.mExtras;
        r19 = NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL;
    L67:
        if (r17.mSortKey == null) goto L69;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_SORT_KEY, r17.mSortKey);
        goto L69
    L42:
        if (ZeusTransformUtils.instanceOf(r17.mStyle, NotificationCompat.CallStyle.class) == false) goto L47;
        Iterator<NotificationCompat.Action> r20 = ((NotificationCompat.CallStyle) ZeusTransformUtils.preCheckCast(r17.mStyle, NotificationCompat.CallStyle.class, "com.obric.memorydata.plugin")).getActionsListWithSystemActions().iterator();
    L45:
        if (r20.hasNext() == false) goto L52;
        addAction((NotificationCompat.Action) ZeusTransformUtils.preCheckCast(r20.next(), NotificationCompat.Action.class, "com.obric.memorydata.plugin"));
    L71:
        if (Build.VERSION.SDK_INT < 17) goto L74;
        Api17Impl.setShowWhen(this.mBuilder, r17.mShowWhen);
    L74:
        if (Build.VERSION.SDK_INT < 19) goto L83;
        if (Build.VERSION.SDK_INT >= 21) goto L83;
        List<String> r21 = combineLists(getPeople(r17.mPersonList), r17.mPeople);
        if (r21 == null) goto L83;
        if (r21.isEmpty() == true) goto L83;
        this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) ZeusTransformUtils.preCheckCast(r21.toArray(new String[r21.size()]), String[].class, "com.obric.memorydata.plugin"));
    L83:
        if (Build.VERSION.SDK_INT < 20) goto L86;
        Api20Impl.setLocalOnly(this.mBuilder, r17.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, r17.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, r17.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, r17.mGroupSummary);
        this.mGroupAlertBehavior = r17.mGroupAlertBehavior;
    L86:
        if (Build.VERSION.SDK_INT < 21) goto L109;
        Api21Impl.setCategory(this.mBuilder, r17.mCategory);
        Api21Impl.setColor(this.mBuilder, r17.mColor);
        Api21Impl.setVisibility(this.mBuilder, r17.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, r17.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, r5.sound, r5.audioAttributes);
        if (Build.VERSION.SDK_INT >= 28) goto L90;
        List r22 = combineLists(getPeople(r17.mPersonList), r17.mPeople);
    L91:
        if (r22 != null) goto L93;
    L98:
        this.mHeadsUpContentView = r17.mHeadsUpContentView;
        if (r17.mInvisibleActions.size() <= 0) goto L109;
        Bundle r23 = r17.getExtras().getBundle("android.car.EXTENSIONS");
        if (r23 != null) goto L103;
        r23 = new Bundle();
    L103:
        Bundle r110 = new Bundle(r23);
        Bundle r111 = new Bundle();
        int r112 = 0;
    L105:
        if (r112 >= r17.mInvisibleActions.size()) goto L107;
        r111.putBundle(Integer.toString(r112), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action) ZeusTransformUtils.preCheckCast(r17.mInvisibleActions.get(r112), NotificationCompat.Action.class, "com.obric.memorydata.plugin")));
        r112 = r112 + 1;
        goto L105
    L107:
        r23.putBundle("invisible_actions", r111);
        r110.putBundle("invisible_actions", r111);
        r17.getExtras().putBundle("android.car.EXTENSIONS", r23);
        this.mExtras.putBundle("android.car.EXTENSIONS", r110);
        goto L109
    L93:
        if (r22.isEmpty() == true) goto L98;
        Iterator r24 = r22.iterator();
    L96:
        if (r24.hasNext() == false) goto L98;
        Api21Impl.addPerson(this.mBuilder, (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin"));
        goto L96
    L90:
        r22 = r17.mPeople;
    L109:
        if (Build.VERSION.SDK_INT < 23) goto L114;
        if (r17.mSmallIcon == null) goto L114;
        Api23Impl.setSmallIcon(this.mBuilder, r17.mSmallIcon);
    L114:
        if (Build.VERSION.SDK_INT < 24) goto L125;
        Api19Impl.setExtras(this.mBuilder, r17.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, r17.mRemoteInputHistory);
        if (r17.mContentView == null) goto L119;
        Api24Impl.setCustomContentView(this.mBuilder, r17.mContentView);
    L119:
        if (r17.mBigContentView == null) goto L122;
        Api24Impl.setCustomBigContentView(this.mBuilder, r17.mBigContentView);
    L122:
        if (r17.mHeadsUpContentView == null) goto L125;
        Api24Impl.setCustomHeadsUpContentView(this.mBuilder, r17.mHeadsUpContentView);
    L125:
        if (Build.VERSION.SDK_INT < 26) goto L133;
        Api26Impl.setBadgeIconType(this.mBuilder, r17.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, r17.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, r17.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, r17.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, r17.mGroupAlertBehavior);
        if (r17.mColorizedSet == false) goto L130;
        Api26Impl.setColorized(this.mBuilder, r17.mColorized);
    L130:
        if (TextUtils.isEmpty(r17.mChannelId) == true) goto L133;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L133:
        if (Build.VERSION.SDK_INT < 28) goto L139;
        Iterator<Person> r25 = r17.mPersonList.iterator();
    L136:
        if (r25.hasNext() == false) goto L139;
        Api28Impl.addPerson(this.mBuilder, ((Person) ZeusTransformUtils.preCheckCast(r25.next(), Person.class, "com.obric.memorydata.plugin")).toAndroidPerson());
    L139:
        if (Build.VERSION.SDK_INT < 29) goto L144;
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, r17.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(r17.mBubbleMetadata));
        if (r17.mLocusId == null) goto L144;
        Api29Impl.setLocusId(this.mBuilder, r17.mLocusId.toLocusId());
    L144:
        if (Build.VERSION.SDK_INT < 31) goto L149;
        if (r17.mFgsDeferBehavior == 0) goto L149;
        Api31Impl.setForegroundServiceBehavior(this.mBuilder, r17.mFgsDeferBehavior);
    L149:
        if (r17.mSilent == true) goto L151;
        return;
    L151:
        if (this.mBuilderCompat.mGroupSummary == false) goto L153;
        int r1 = 2;
    L154:
        this.mGroupAlertBehavior = r1;
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        r5.defaults &= -2;
        r5.defaults &= -3;
        this.mBuilder.setDefaults(r5.defaults);
        if (Build.VERSION.SDK_INT >= 26) goto L157;
        return;
    L157:
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L159;
        Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
    L159:
        Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        return;
    L153:
        r1 = 1;
        goto L154
    L27:
        r15 = r17.mLargeIcon.getBitmap();
        goto L28
    L29:
        Notification.Builder r26 = this.mBuilder;
        if (r17.mLargeIcon != null) goto L32;
        Icon r27 = null;
    L33:
        Api23Impl.setLargeIcon(r26, r27);
        goto L35
    L32:
        r27 = r17.mLargeIcon.toIcon(r2);
        goto L33
    L21:
        r14 = false;
        goto L22
    L17:
        r11 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r4 = new Notification.Builder(r17.mContext);
        goto L6
    }

    private void addAction(NotificationCompat.Action r6) {
        if (Build.VERSION.SDK_INT < 20) goto L37;
        IconCompat r0 = r6.getIconCompat();
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r0 == null) goto L8;
        Icon r1 = r0.toIcon();
    L9:
        Notification.Action.Builder r2 = Api23Impl.createBuilder(r1, r6.getTitle(), r6.getActionIntent());
    L15:
        if (r6.getRemoteInputs() == null) goto L20;
        android.app.RemoteInput[] r4 = RemoteInput.fromCompat(r6.getRemoteInputs());
        int r5 = r4.length;
    L17:
        if (r3 >= r5) goto L20;
        Api20Impl.addRemoteInput(r2, r4[r3]);
        r3 = r3 + 1;
    L20:
        if (r6.getExtras() == null) goto L22;
        Bundle r7 = new Bundle(r6.getExtras());
    L23:
        r7.putBoolean("android.support.allowGeneratedReplies", r6.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT < 24) goto L26;
        Api24Impl.setAllowGeneratedReplies(r2, r6.getAllowGeneratedReplies());
    L26:
        r7.putInt("android.support.action.semanticAction", r6.getSemanticAction());
        if (Build.VERSION.SDK_INT < 28) goto L30;
        Api28Impl.setSemanticAction(r2, r6.getSemanticAction());
    L30:
        if (Build.VERSION.SDK_INT < 29) goto L33;
        Api29Impl.setContextual(r2, r6.isContextual());
    L33:
        if (Build.VERSION.SDK_INT < 31) goto L35;
        Api31Impl.setAuthenticationRequired(r2, r6.isAuthenticationRequired());
    L35:
        r7.putBoolean("android.support.action.showsUserInterface", r6.getShowsUserInterface());
        Api20Impl.addExtras(r2, r7);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(r2));
        return;
    L22:
        r7 = new Bundle();
        goto L23
    L8:
        r1 = null;
        goto L9
    L10:
        if (r0 == null) goto L12;
        int r8 = r0.getResId();
    L13:
        r2 = Api20Impl.createBuilder(r8, r6.getTitle(), r6.getActionIntent());
        goto L15
    L12:
        r8 = 0;
        goto L13
    L37:
        if (Build.VERSION.SDK_INT < 16) goto L42;
        this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, r6));
        return;
    }

    private static List<String> combineLists(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return r6;
    L5:
        if (r6 != null) goto L7;
        return r5;
    L7:
        ArraySet r0 = new ArraySet(r5.size() + r6.size());
        r0.addAll(r5);
        r0.addAll(r6);
        return new ArrayList(r0);
    }

    private static List<String> getPeople(List<Person> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList(r5.size());
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0.add(((Person) ZeusTransformUtils.preCheckCast(r6.next(), Person.class, "com.obric.memorydata.plugin")).resolveToLegacyUri());
        goto L8
    L10:
        return r0;
    }

    private void removeSoundAndVibration(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        r1.defaults &= -2;
        r1.defaults &= -3;
    }

    public Notification build() {
        NotificationCompat.Style r0 = this.mBuilderCompat.mStyle;
        if (r0 == null) goto L5;
        r0.apply(this);
    L5:
        if (r0 == null) goto L7;
        RemoteViews r1 = r0.makeContentView(this);
    L8:
        Notification r2 = buildInternal();
        if (r1 == null) goto L12;
    L10:
        r2.contentView = r1;
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L21;
        if (r0 == null) goto L21;
        RemoteViews r3 = r0.makeBigContentView(this);
        if (r3 == null) goto L21;
        r2.bigContentView = r3;
    L21:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        if (r0 == null) goto L27;
        RemoteViews r5 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r5 == null) goto L27;
        r2.headsUpContentView = r5;
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L32;
        if (r0 == null) goto L32;
        Bundle r6 = NotificationCompat.getExtras(r2);
        if (r6 == null) goto L32;
        r0.addCompatExtras(r6);
    L32:
        return r2;
    L12:
        if (this.mBuilderCompat.mContentView == null) goto L15;
        r1 = this.mBuilderCompat.mContentView;
        goto L10
    L7:
        r1 = null;
        goto L8
    }

    public Notification buildInternal() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api16Impl.build(this.mBuilder);
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L26;
        Notification r0 = Api16Impl.build(this.mBuilder);
        if (this.mGroupAlertBehavior != 0) goto L11;
    L24:
        return r0;
    L11:
        if (Api20Impl.getGroup(r0) == null) goto L18;
        if ((r0.flags & 512) == 0) goto L18;
        if (this.mGroupAlertBehavior != 2) goto L18;
        removeSoundAndVibration(r0);
    L18:
        if (Api20Impl.getGroup(r0) == null) goto L24;
        if ((r0.flags & 512) != 0) goto L24;
        if (this.mGroupAlertBehavior != 1) goto L24;
        removeSoundAndVibration(r0);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L54;
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r1 = Api16Impl.build(this.mBuilder);
        RemoteViews r2 = this.mContentView;
        if (r2 == null) goto L30;
        r1.contentView = r2;
    L30:
        RemoteViews r3 = this.mBigContentView;
        if (r3 == null) goto L33;
        r1.bigContentView = r3;
    L33:
        RemoteViews r4 = this.mHeadsUpContentView;
        if (r4 == null) goto L37;
        r1.headsUpContentView = r4;
    L37:
        if (this.mGroupAlertBehavior != 0) goto L39;
    L52:
        return r1;
    L39:
        if (Api20Impl.getGroup(r1) == null) goto L46;
        if ((r1.flags & 512) == 0) goto L46;
        if (this.mGroupAlertBehavior != 2) goto L46;
        removeSoundAndVibration(r1);
    L46:
        if (Api20Impl.getGroup(r1) == null) goto L52;
        if ((r1.flags & 512) != 0) goto L52;
        if (this.mGroupAlertBehavior != 1) goto L52;
        removeSoundAndVibration(r1);
        goto L52
    L54:
        if (Build.VERSION.SDK_INT < 20) goto L79;
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r5 = Api16Impl.build(this.mBuilder);
        RemoteViews r6 = this.mContentView;
        if (r6 == null) goto L58;
        r5.contentView = r6;
    L58:
        RemoteViews r7 = this.mBigContentView;
        if (r7 == null) goto L62;
        r5.bigContentView = r7;
    L62:
        if (this.mGroupAlertBehavior != 0) goto L64;
    L77:
        return r5;
    L64:
        if (Api20Impl.getGroup(r5) == null) goto L71;
        if ((r5.flags & 512) == 0) goto L71;
        if (this.mGroupAlertBehavior != 2) goto L71;
        removeSoundAndVibration(r5);
    L71:
        if (Api20Impl.getGroup(r5) == null) goto L77;
        if ((r5.flags & 512) != 0) goto L77;
        if (this.mGroupAlertBehavior != 1) goto L77;
        removeSoundAndVibration(r5);
        goto L77
    L79:
        if (Build.VERSION.SDK_INT < 19) goto L91;
        SparseArray<Bundle> r8 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r8 == null) goto L83;
        this.mExtras.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r8);
    L83:
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification r9 = Api16Impl.build(this.mBuilder);
        RemoteViews r10 = this.mContentView;
        if (r10 == null) goto L86;
        r9.contentView = r10;
    L86:
        RemoteViews r11 = this.mBigContentView;
        if (r11 == null) goto L89;
        r9.bigContentView = r11;
    L89:
        return r9;
    L91:
        if (Build.VERSION.SDK_INT < 16) goto L109;
        Notification r12 = Api16Impl.build(this.mBuilder);
        Bundle r13 = NotificationCompat.getExtras(r12);
        Bundle r14 = new Bundle(this.mExtras);
        Iterator<String> r15 = this.mExtras.keySet().iterator();
    L94:
        if (r15.hasNext() == false) goto L98;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r13.containsKey(r16) == false) goto L94;
        r14.remove(r16);
        goto L94
    L98:
        r13.putAll(r14);
        SparseArray<Bundle> r17 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r17 == null) goto L101;
        NotificationCompat.getExtras(r12).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r17);
    L101:
        RemoteViews r18 = this.mContentView;
        if (r18 == null) goto L104;
        r12.contentView = r18;
    L104:
        RemoteViews r19 = this.mBigContentView;
        if (r19 == null) goto L107;
        r12.bigContentView = r19;
    L107:
        return r12;
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
