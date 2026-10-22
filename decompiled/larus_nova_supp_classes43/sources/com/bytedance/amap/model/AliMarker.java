package com.bytedance.amap.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.AlphaAnimation;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.AnimationSet;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.monitor.MapMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliMarker implements IMarker {
    private static final String TAG = "AliMarker";
    private String mId;
    private boolean mIsSelected;
    private boolean mIsVisible;
    private Marker mMarker;
    private Point mScreenPoint;

    public final /* synthetic */ boolean isCollideWithPoi() {
        return IMarker.-CC.$default$isCollideWithPoi(this);
    }

    public final /* synthetic */ void setCollideWithPoi(boolean r1) {
        IMarker.-CC.$default$setCollideWithPoi(this, r1);
    }

    public final /* synthetic */ void updateMarker(Map r1) {
        IMarker.-CC.$default$updateMarker(this, r1);
    }

    private Animation getHideAnimation() {
        AnimationSet r0 = new AnimationSet(true);
        r0.setDuration(300);
        AlphaAnimation r1 = new AlphaAnimation(1.0f, 0.5f);
        ScaleAnimation r10 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
        r0.addAnimation(r1);
        r0.addAnimation(r10);
        r0.setFillMode(0);
        return r0;
    }

    private Animation getShowAnimation() {
        AnimationSet r0 = new AnimationSet(true);
        r0.setDuration(300);
        AlphaAnimation r1 = new AlphaAnimation(0.5f, 1.0f);
        ScaleAnimation r10 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        r0.addAnimation(r1);
        r0.addAnimation(r10);
        r0.setFillMode(0);
        return r0;
    }

    public void destroy() {
        this.mMarker.destroy();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "destroy error:" + e.getMessage());
    }

    public Object getData() {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getObject();
    }

    public BDLatLng getPosition() {
        LatLng r0 = this.mMarker.getPosition();     // Catch: Exception -> L4
        return new BDLatLng(r0.latitude, r0.longitude);
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getPosition error:" + e.getMessage());
        return new BDLatLng(0.0d, 0.0d);
    }

    public String getSnippet() {
        return this.mMarker.getSnippet();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getTitle error:" + e.getMessage());
        return null;
    }

    public String getTitle() {
        return this.mMarker.getTitle();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getTitle error:" + e.getMessage());
        return null;
    }

    public float getZIndex() {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getZIndex();
    }

    public void hideInfoWindow() {
        this.mMarker.hideInfoWindow();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "hideInfoWindow error:" + e.getMessage());
    }

    public boolean isDraggable() {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDraggable();
    }

    public boolean isInfoWindowShown() {
        return this.mMarker.isInfoWindowShown();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "isInfoWindowShown error:" + e.getMessage());
        return false;
    }

    public boolean isVisible() {
        return this.mMarker.isVisible();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "isVisible error:" + e.getMessage());
        return false;
    }

    public void remove() {
        this.mMarker.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    public void setToTop() {
        this.mMarker.setToTop();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setToTop error:" + e.getMessage());
    }

    public void showInfoWindow() {
        this.mMarker.showInfoWindow();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "showInfoWindow error:" + e.getMessage());
    }

    public String getId() {
        return this.mId;
    }

    public Marker getMarker() {
        return this.mMarker;
    }

    public Point getScreenPoint() {
        return this.mScreenPoint;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public static /* synthetic */ Marker access$000(AliMarker r0) {
        return r0.mMarker;
    }

    public Rect getVisibleRect(Point r10) {
        Rect r0 = new Rect();
        Marker r1 = this.mMarker;
        if (r1 == null) goto L15;
        if (r10 == null) goto L15;
        if (r1.getOptions() == null) goto L15;
        if (this.mMarker.getOptions().getIcon() == null) goto L15;
        Bitmap r11 = this.mMarker.getOptions().getIcon().getBitmap();
        if (r11 != null) goto L14;
        return r0;
    L14:
        float r12 = this.mMarker.getOptions().getAnchorU();
        float r13 = this.mMarker.getOptions().getAnchorV();
        int r14 = r10.x - ((int) (r11.getWidth() * r12));
        r0.left = r14;
        r0.right = r14 + r11.getWidth();
        int r15 = r10.y - ((int) (r11.getHeight() * r13));
        r0.top = r15;
        r0.bottom = r15 + r11.getHeight();
    L15:
        return r0;
    }

    public void setAlpha(float r10) {
        this.mMarker.setAlpha(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setAlpha error:" + e.getMessage());
    }

    public void setClickable(boolean r10) {
        this.mMarker.setClickable(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setClickable error:" + e.getMessage());
    }

    public void setData(Object r10) {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setObject(r10);
    }

    public void setDraggable(boolean r10) {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setDraggable(r10);
    }

    public void setIcons(List<Bitmap> r10) {
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L8
        Iterator<Bitmap> r11 = r10.iterator();     // Catch: Exception -> L8
    L4:
        if (r11.hasNext() == false) goto L6;
        r0.add(BitmapDescriptorFactory.fromBitmap(r11.next()));     // Catch: Exception -> L8
        goto L4
    L6:
        this.mMarker.setIcons(r0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setIcons error:" + e.getMessage());
    }

    public void setRotateAngle(float r10) {
        this.mMarker.setRotateAngle(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setRotateAngle error:" + e.getMessage());
    }

    public void setScreenPoint(Point r10) {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setPositionByPixels(r10.x, r10.y);
        this.mScreenPoint = r10;
    }

    public void setSelected(boolean r1) {
        this.mIsSelected = r1;
    }

    public void setVisible(boolean r10) {
        this.mMarker.setVisible(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setVisible error:" + e.getMessage());
    }

    public void setZIndex(float r10) {
        this.mMarker.setZIndex(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setZIndex error:" + e.getMessage());
    }

    public void startAnimation(Object r10) {
    L6:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "startAnimation error:" + e.getMessage());
        return;
    L3:
        if ((r10 instanceof AnimationSet) == false) goto L11;
        this.mMarker.setAnimation((Animation) r10);     // Catch: Exception -> L6
        this.mMarker.startAnimation();     // Catch: Exception -> L6
        return;
    }

    public void updateMarkerIcon(Bitmap r10) {
        this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(r10));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateMarkerIcon error:" + e.getMessage());
    }

    public void updatePosition(BDLatLng r10) {
        this.mMarker.setPosition(new LatLng(r10.getLatitude(), r10.getLongitude()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updatePosition error:" + e.getMessage());
    }

    public void updateMarkerIcon(View r10) {
        this.mMarker.setIcon(BitmapDescriptorFactory.fromView(r10));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateMarkerIcon error:" + e.getMessage());
    }

    public AliMarker(Marker r10, String r11) {
        this.mIsSelected = false;
        this.mIsVisible = true;
        this.mScreenPoint = null;
        this.mMarker = r10;
        this.mId = r11;
    }

    public void setAnchor(float r10, float r11) {
        Marker r0 = this.mMarker;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setAnchor(r10, r11);
    }

    public void setVisible(boolean r10, boolean r11) {
        if (r10 == this.mIsVisible) goto L14;
        Marker r0 = this.mMarker;
        if (r0 == null) goto L17;
        this.mIsVisible = r10;
        if (r11 == true) goto L10;
        r0.setVisible(r10);
        return;
    L10:
        if (r10 == false) goto L12;
        r0.setVisible(true);
        Animation r12 = getShowAnimation();
        this.mMarker.setAnimation(r12);
        this.mMarker.startAnimation();
        return;
    L12:
        Animation r13 = getHideAnimation();
        this.mMarker.setAnimation(r13);
        this.mMarker.setAnimationListener(new AnonymousClass1(this));
        this.mMarker.startAnimation();
        return;
    L17:
        return;
    }

    public AliMarker(Marker r10, String r11, Point r12) {
        this.mIsSelected = false;
        this.mIsVisible = true;
        this.mMarker = r10;
        this.mId = r11;
        this.mScreenPoint = r12;
        if (r10 == null) goto L6;
        this.mIsVisible = r10.isVisible();
        return;
    }
}
