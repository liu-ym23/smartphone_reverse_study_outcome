package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle() {
        }

        private void setBackgroundColor(RemoteViews r5) {
            if (this.mBuilder.getColor() == 0) goto L5;
            int r10 = this.mBuilder.getColor();
        L6:
            r5.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", r10);
            return;
        L5:
            r10 = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            goto L6
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            r5.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int r5) {
            if (r5 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow_custom;
        L6:
            return R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return R.layout.notification_template_media_custom;
        L6:
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat$Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r5) {
            if (r5.getActionIntent() != null) goto L5;
            boolean r10 = true;
        L6:
            RemoteViews r11 = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            r11.setImageViewResource(R.id.action0, r5.getIcon());
            if (r10 == true) goto L9;
            r11.setOnClickPendingIntent(R.id.action0, r5.getActionIntent());
        L9:
            r11.setContentDescription(R.id.action0, r5.getTitle());
            return r11;
        L5:
            r10 = false;
            goto L6
        }

        public static MediaSessionCompat$Token getMediaSession(Notification r5) {
            Bundle r10 = androidx.core.app.NotificationCompat.getExtras(r5);
            if (r10 == null) goto L8;
            Parcelable r11 = r10.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r11 == null) goto L8;
            return MediaSessionCompat$Token.c(r11, null);
        L8:
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r5) {
            r5.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        }

        @RequiresApi(21)
        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r5) {
            int[] r10 = this.mActionsToShowInCompact;
            if (r10 == null) goto L5;
            r5.setShowActionsInCompactView(r10);
        L5:
            MediaSessionCompat$Token r11 = this.mToken;
            if (r11 == null) goto L8;
            r5.setMediaSession((MediaSession.Token) r11.f379a);
        L8:
            return r5;
        }

        public RemoteViews generateBigContentView() {
            int r5 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r10 = applyStandardTemplate(false, getBigContentViewLayoutResource(r5), false);
            r10.removeAllViews(R.id.media_actions);
            if (r5 <= 0) goto L8;
            int r11 = 0;
        L5:
            if (r11 >= r5) goto L8;
            r10.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(r11)));
            r11 = r11 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            r10.setViewVisibility(R.id.cancel_action, 0);
            r10.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            r10.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        L11:
            return r10;
        L10:
            r10.setViewVisibility(R.id.cancel_action, 8);
            goto L11
        }

        public RemoteViews generateContentView() {
            RemoteViews r5 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r10 = this.mBuilder.mActions.size();
            int[] r11 = this.mActionsToShowInCompact;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            r5.removeAllViews(R.id.media_actions);
            if (r12 <= 0) goto L15;
            int r13 = 0;
        L9:
            if (r13 >= r12) goto L15;
            if (r13 >= r10) goto L13;
            r5.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[r13])));
            r13 = r13 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r13), Integer.valueOf(r10 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r5.setViewVisibility(R.id.end_padder, 8);
            r5.setViewVisibility(R.id.cancel_action, 0);
            r5.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            r5.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        L18:
            return r5;
        L17:
            r5.setViewVisibility(R.id.end_padder, 0);
            r5.setViewVisibility(R.id.cancel_action, 8);
            goto L18
        L5:
            r12 = Math.min(r11.length, 3);
            goto L6
        }

        public int getBigContentViewLayoutResource(int r5) {
            if (r5 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow;
        L6:
            return R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r5) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r5) {
            this.mCancelButtonIntent = r5;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat$Token r5) {
            this.mToken = r5;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... r5) {
            this.mActionsToShowInCompact = r5;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean r5) {
            return this;
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r5) {
            this.mActionsToShowInCompact = null;
            setBuilder(r5);
        }
    }

    private NotificationCompat() {
    }
}
