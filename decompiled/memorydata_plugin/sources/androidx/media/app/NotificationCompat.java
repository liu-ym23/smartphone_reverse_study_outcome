package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle() {
        }

        private void setBackgroundColor(RemoteViews r4) {
            int r0 = this.mBuilder.getColor();
            androidx.core.app.NotificationCompat.Builder r3 = this.mBuilder;
            if (r0 == 0) goto L5;
            int r5 = r3.getColor();
        L6:
            r4.setInt(ZeusTransformUtils.mapRes(R.id.status_bar_latest_event_content, OaidModel.KEY_ID, "status_bar_latest_event_content"), "setBackgroundColor", r5);
            return;
        L5:
            r5 = ZeusTransformUtils.getResources(r3.mContext, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.notification_material_background_media_default_color, TypedValues.Custom.S_COLOR, "notification_material_background_media_default_color"));
            goto L6
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r4.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            return;
        L5:
            super.apply(r4);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int r2) {
            if (r2 > 3) goto L5;
            int r3 = R.layout.notification_template_big_media_narrow_custom;
            String r0 = "notification_template_big_media_narrow_custom";
        L7:
            return ZeusTransformUtils.mapRes(r3, "layout", r0);
        L5:
            r3 = R.layout.notification_template_big_media_custom;
            r0 = "notification_template_big_media_custom";
            goto L7
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return ZeusTransformUtils.mapRes(R.layout.notification_template_media_custom, "layout", "notification_template_media_custom");
        L6:
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getBigContentView() == null) goto L8;
            RemoteViews r5 = this.mBuilder.getBigContentView();
        L9:
            if (r5 != null) goto L11;
            return null;
        L11:
            RemoteViews r0 = generateBigContentView();
            buildIntoRemoteViews(r0, r5);
            if (Build.VERSION.SDK_INT < 21) goto L14;
            setBackgroundColor(r0);
        L14:
            return r0;
        L8:
            r5 = this.mBuilder.getContentView();
            goto L9
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r6) {
            NotificationBuilderWithBuilderAccessor r7 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r6, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            boolean r1 = true;
            if (this.mBuilder.getContentView() == null) goto L8;
            boolean r8 = true;
        L10:
            if (Build.VERSION.SDK_INT < 21) goto L22;
            if (r8 == false) goto L13;
        L16:
            if (r1 == false) goto L26;
            RemoteViews r0 = generateContentView();
            if (r8 == false) goto L20;
            buildIntoRemoteViews(r0, this.mBuilder.getContentView());
        L20:
            setBackgroundColor(r0);
            return r0;
        L26:
            return null;
        L13:
            if (this.mBuilder.getBigContentView() != null) goto L16;
            r1 = false;
            goto L16
        L22:
            RemoteViews r2 = generateContentView();
            if (r8 == false) goto L26;
            buildIntoRemoteViews(r2, this.mBuilder.getContentView());
            return r2;
        L8:
            r8 = false;
            goto L10
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getHeadsUpContentView() == null) goto L8;
            RemoteViews r5 = this.mBuilder.getHeadsUpContentView();
        L9:
            if (r5 != null) goto L11;
            return null;
        L11:
            RemoteViews r0 = generateBigContentView();
            buildIntoRemoteViews(r0, r5);
            if (Build.VERSION.SDK_INT < 21) goto L14;
            setBackgroundColor(r0);
        L14:
            return r0;
        L8:
            r5 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r2) {
            this.mActionsToShowInCompact = null;
            setBuilder(r2);
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r6) {
            if (r6.getActionIntent() != null) goto L5;
            boolean r0 = true;
        L6:
            RemoteViews r1 = new RemoteViews(this.mBuilder.mContext.getPackageName(), ZeusTransformUtils.mapRes(R.layout.notification_media_action, "layout", "notification_media_action"));
            r1.setImageViewResource(ZeusTransformUtils.mapRes(R.id.action0, OaidModel.KEY_ID, "action0"), r6.getIcon());
            if (r0 == true) goto L10;
            r1.setOnClickPendingIntent(ZeusTransformUtils.mapRes(R.id.action0, OaidModel.KEY_ID, "action0"), r6.getActionIntent());
        L10:
            if (Build.VERSION.SDK_INT < 15) goto L12;
            r1.setContentDescription(ZeusTransformUtils.mapRes(R.id.action0, OaidModel.KEY_ID, "action0"), r6.getTitle());
        L12:
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        public static MediaSessionCompat.Token getMediaSession(Notification r3) {
            Bundle r4 = androidx.core.app.NotificationCompat.getExtras(r3);
            if (r4 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Parcelable r5 = r4.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r5 != null) goto L9;
            return null;
        L9:
            return MediaSessionCompat.Token.fromToken(r5);
        L10:
            IBinder r6 = BundleCompat.getBinder(r4, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r6 == null) goto L17;
            Parcel r0 = Parcel.obtain();
            r0.writeStrongBinder(r6);
            r0.setDataPosition(0);
            MediaSessionCompat.Token r7 = (MediaSessionCompat.Token) ZeusTransformUtils.preCheckCast(MediaSessionCompat.Token.CREATOR.createFromParcel(r0), MediaSessionCompat.Token.class, "com.obric.memorydata.plugin");
            r0.recycle();
            return r7;
        L17:
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r4.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
            return;
        L6:
            if (this.mShowCancelButton == false) goto L10;
            r4.getBuilder().setOngoing(true);
            return;
        }

        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r3) {
            int[] r0 = this.mActionsToShowInCompact;
            if (r0 == null) goto L5;
            r3.setShowActionsInCompactView(r0);
        L5:
            MediaSessionCompat.Token r2 = this.mToken;
            if (r2 == null) goto L8;
            r3.setMediaSession((MediaSession.Token) ZeusTransformUtils.preCheckCast(r2.getToken(), MediaSession.Token.class, "com.obric.memorydata.plugin"));
        L8:
            return r3;
        }

        RemoteViews generateBigContentView() {
            int r0 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r1 = applyStandardTemplate(false, getBigContentViewLayoutResource(r0), false);
            r1.removeAllViews(ZeusTransformUtils.mapRes(R.id.media_actions, OaidModel.KEY_ID, "media_actions"));
            if (r0 <= 0) goto L8;
            int r6 = 0;
        L5:
            if (r6 >= r0) goto L8;
            r1.addView(ZeusTransformUtils.mapRes(R.id.media_actions, OaidModel.KEY_ID, "media_actions"), generateMediaActionButton((androidx.core.app.NotificationCompat.Action) ZeusTransformUtils.preCheckCast(this.mBuilder.mActions.get(r6), androidx.core.app.NotificationCompat.Action.class, "com.obric.memorydata.plugin")));
            r6 = r6 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            r1.setViewVisibility(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), 0);
            r1.setInt(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), "setAlpha", ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.cancel_button_image_alpha, TypedValues.Custom.S_INT, "cancel_button_image_alpha")));
            r1.setOnClickPendingIntent(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), this.mCancelButtonIntent);
        L11:
            return r1;
        L10:
            r1.setViewVisibility(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), 8);
            goto L11
        }

        RemoteViews generateContentView() {
            RemoteViews r0 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r3 = this.mBuilder.mActions.size();
            int[] r4 = this.mActionsToShowInCompact;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            r0.removeAllViews(ZeusTransformUtils.mapRes(R.id.media_actions, OaidModel.KEY_ID, "media_actions"));
            if (r5 <= 0) goto L15;
            int r8 = 0;
        L9:
            if (r8 >= r5) goto L15;
            if (r8 >= r3) goto L13;
            r0.addView(ZeusTransformUtils.mapRes(R.id.media_actions, OaidModel.KEY_ID, "media_actions"), generateMediaActionButton((androidx.core.app.NotificationCompat.Action) ZeusTransformUtils.preCheckCast(this.mBuilder.mActions.get(this.mActionsToShowInCompact[r8]), androidx.core.app.NotificationCompat.Action.class, "com.obric.memorydata.plugin")));
            r8 = r8 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r8), Integer.valueOf(r3 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.end_padder, OaidModel.KEY_ID, "end_padder"), 8);
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), 0);
            r0.setOnClickPendingIntent(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), this.mCancelButtonIntent);
            r0.setInt(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), "setAlpha", ZeusTransformUtils.getResources(this.mBuilder.mContext, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.cancel_button_image_alpha, TypedValues.Custom.S_INT, "cancel_button_image_alpha")));
        L18:
            return r0;
        L17:
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.end_padder, OaidModel.KEY_ID, "end_padder"), 0);
            r0.setViewVisibility(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action"), 8);
            goto L18
        L5:
            r5 = Math.min(r4.length, 3);
            goto L6
        }

        int getBigContentViewLayoutResource(int r2) {
            if (r2 > 3) goto L5;
            int r3 = R.layout.notification_template_big_media_narrow;
            String r0 = "notification_template_big_media_narrow";
        L7:
            return ZeusTransformUtils.mapRes(r3, "layout", r0);
        L5:
            r3 = R.layout.notification_template_big_media;
            r0 = "notification_template_big_media";
            goto L7
        }

        int getContentViewLayoutResource() {
            return ZeusTransformUtils.mapRes(R.layout.notification_template_media, "layout", "notification_template_media");
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateBigContentView();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r3) {
            NotificationBuilderWithBuilderAccessor r4 = (NotificationBuilderWithBuilderAccessor) ZeusTransformUtils.wrapperContextForParams(r3, NotificationBuilderWithBuilderAccessor.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r1) {
            this.mCancelButtonIntent = r1;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token r1) {
            this.mToken = r1;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... r1) {
            this.mActionsToShowInCompact = r1;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean r3) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            this.mShowCancelButton = r3;
        L5:
            return this;
        }
    }

    private NotificationCompat() {
    }
}
