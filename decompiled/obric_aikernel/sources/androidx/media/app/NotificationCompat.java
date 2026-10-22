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
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle() {
        }

        private void setBackgroundColor(RemoteViews r10) {
            int r11 = this.mBuilder.getColor();
            androidx.core.app.NotificationCompat.Builder r12 = this.mBuilder;
            if (r11 == 0) goto L5;
            int r13 = r12.getColor();
        L6:
            r10.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", r13);
            return;
        L5:
            r13 = r12.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            goto L6
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r10.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            return;
        L5:
            super.apply(r10);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int r10) {
            if (r10 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow_custom;
        L6:
            return R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return R.layout.notification_template_media_custom;
        L6:
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getBigContentView() == null) goto L8;
            RemoteViews r12 = this.mBuilder.getBigContentView();
        L9:
            if (r12 != null) goto L11;
            return null;
        L11:
            RemoteViews r13 = generateBigContentView();
            buildIntoRemoteViews(r13, r12);
            if (r11 < 21) goto L14;
            setBackgroundColor(r13);
        L14:
            return r13;
        L8:
            r12 = this.mBuilder.getContentView();
            goto L9
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 24) goto L5;
            return null;
        L5:
            boolean r12 = true;
            if (this.mBuilder.getContentView() == null) goto L8;
            boolean r13 = true;
        L10:
            if (r11 < 21) goto L22;
            if (r13 == false) goto L13;
        L16:
            if (r12 == false) goto L26;
            RemoteViews r14 = generateContentView();
            if (r13 == false) goto L20;
            buildIntoRemoteViews(r14, this.mBuilder.getContentView());
        L20:
            setBackgroundColor(r14);
            return r14;
        L26:
            return null;
        L13:
            if (this.mBuilder.getBigContentView() != null) goto L16;
            r12 = false;
            goto L16
        L22:
            RemoteViews r15 = generateContentView();
            if (r13 == false) goto L26;
            buildIntoRemoteViews(r15, this.mBuilder.getContentView());
            return r15;
        L8:
            r13 = false;
            goto L10
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getHeadsUpContentView() == null) goto L8;
            RemoteViews r12 = this.mBuilder.getHeadsUpContentView();
        L9:
            if (r12 != null) goto L11;
            return null;
        L11:
            RemoteViews r13 = generateBigContentView();
            buildIntoRemoteViews(r13, r12);
            if (r11 < 21) goto L14;
            setBackgroundColor(r13);
        L14:
            return r13;
        L8:
            r12 = this.mBuilder.getContentView();
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

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r10) {
            this.mActionsToShowInCompact = null;
            setBuilder(r10);
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r10) {
            if (r10.getActionIntent() != null) goto L5;
            boolean r11 = true;
        L6:
            RemoteViews r12 = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            int r13 = R.id.action0;
            r12.setImageViewResource(r13, r10.getIcon());
            if (r11 == true) goto L10;
            r12.setOnClickPendingIntent(r13, r10.getActionIntent());
        L10:
            if (Build.VERSION.SDK_INT < 15) goto L12;
            r12.setContentDescription(r13, r10.getTitle());
        L12:
            return r12;
        L5:
            r11 = false;
            goto L6
        }

        public static MediaSessionCompat.Token getMediaSession(Notification r10) {
            Bundle r11 = androidx.core.app.NotificationCompat.getExtras(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Parcelable r12 = r11.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r12 != null) goto L9;
            return null;
        L9:
            return MediaSessionCompat.Token.fromToken(r12);
        L10:
            IBinder r13 = BundleCompat.getBinder(r11, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r13 == null) goto L17;
            Parcel r14 = Parcel.obtain();
            r14.writeStrongBinder(r13);
            r14.setDataPosition(0);
            MediaSessionCompat.Token r15 = MediaSessionCompat.Token.CREATOR.createFromParcel(r14);
            r14.recycle();
            return r15;
        L17:
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r10.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
            return;
        L6:
            if (this.mShowCancelButton == false) goto L10;
            r10.getBuilder().setOngoing(true);
            return;
        }

        @RequiresApi(21)
        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r10) {
            int[] r11 = this.mActionsToShowInCompact;
            if (r11 == null) goto L5;
            r10.setShowActionsInCompactView(r11);
        L5:
            MediaSessionCompat.Token r12 = this.mToken;
            if (r12 == null) goto L8;
            r10.setMediaSession((MediaSession.Token) r12.getToken());
        L8:
            return r10;
        }

        RemoteViews generateBigContentView() {
            int r10 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r11 = applyStandardTemplate(false, getBigContentViewLayoutResource(r10), false);
            r11.removeAllViews(R.id.media_actions);
            if (r10 <= 0) goto L8;
            int r12 = 0;
        L5:
            if (r12 >= r10) goto L8;
            r11.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(r12)));
            r12 = r12 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            int r13 = R.id.cancel_action;
            r11.setViewVisibility(r13, 0);
            r11.setInt(r13, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            r11.setOnClickPendingIntent(r13, this.mCancelButtonIntent);
        L11:
            return r11;
        L10:
            r11.setViewVisibility(R.id.cancel_action, 8);
            goto L11
        }

        RemoteViews generateContentView() {
            RemoteViews r10 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r11 = this.mBuilder.mActions.size();
            int[] r12 = this.mActionsToShowInCompact;
            if (r12 != null) goto L5;
            int r13 = 0;
        L6:
            r10.removeAllViews(R.id.media_actions);
            if (r13 <= 0) goto L15;
            int r14 = 0;
        L9:
            if (r14 >= r13) goto L15;
            if (r14 >= r11) goto L13;
            r10.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[r14])));
            r14 = r14 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r14), Integer.valueOf(r11 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r10.setViewVisibility(R.id.end_padder, 8);
            int r15 = R.id.cancel_action;
            r10.setViewVisibility(r15, 0);
            r10.setOnClickPendingIntent(r15, this.mCancelButtonIntent);
            r10.setInt(r15, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        L18:
            return r10;
        L17:
            r10.setViewVisibility(R.id.end_padder, 0);
            r10.setViewVisibility(R.id.cancel_action, 8);
            goto L18
        L5:
            r13 = Math.min(r12.length, 3);
            goto L6
        }

        int getBigContentViewLayoutResource(int r10) {
            if (r10 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow;
        L6:
            return R.layout.notification_template_big_media;
        }

        int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateBigContentView();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r10) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r10) {
            this.mCancelButtonIntent = r10;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token r10) {
            this.mToken = r10;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... r10) {
            this.mActionsToShowInCompact = r10;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean r10) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            this.mShowCancelButton = r10;
        L5:
            return this;
        }
    }

    private NotificationCompat() {
    }
}
