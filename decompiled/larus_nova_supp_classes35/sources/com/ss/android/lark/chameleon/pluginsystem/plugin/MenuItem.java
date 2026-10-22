package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MenuItem implements NonProguard {
    private int badgeNum;
    private String badgeText;
    private ClickListener clickListener;
    private List<String> customColor;
    private boolean enable;
    private Drawable icon;
    private String iconKey;
    private String id;
    private CharSequence spannableText;
    private String text;

    public interface ClickListener {
        void onMenuItemClick(MenuItem r1, View r2);
    }

    public MenuItem() {
        this(null, null);
    }

    public String toString() {
        return String.format("Menu[%s,%s]", new Object[]{this.id, this.text});
    }

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public int getBadgeNum() {
        return this.badgeNum;
    }

    public String getBadgeText() {
        return this.badgeText;
    }

    public List<String> getCustomColor() {
        return this.customColor;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.id;
    }

    public CharSequence getSpannableText() {
        return this.spannableText;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.id, ((MenuItem) r3).id);
    }

    public void onClick(View r2) {
        ClickListener r0 = this.clickListener;
        if (r0 == null) goto L6;
        r0.onMenuItemClick(this, r2);
        return;
    }

    public void setBadgeNum(int r1) {
        this.badgeNum = r1;
    }

    public void setBadgeText(String r1) {
        this.badgeText = r1;
    }

    public void setClickListener(ClickListener r1) {
        this.clickListener = r1;
    }

    public void setCustomColor(List<String> r1) {
        this.customColor = r1;
    }

    public void setDisabled(boolean r1) {
        setEnable(!r1);
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setIcon(Drawable r1) {
        this.icon = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setSpannableText(CharSequence r1) {
        this.spannableText = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }

    public MenuItem(String r2, String r3) {
        this(r2, null, r3);
    }

    public MenuItem(String r2, Drawable r3, String r4) {
        this.enable = true;
        this.id = r2;
        this.icon = r3;
        this.text = r4;
    }

    public static MenuItem fromColorText(Context r2, int r3, int r4) {
        Resources r5 = r2.getResources();
        String r6 = r5.getString(r3);
        int r7 = r5.getColor(r4);
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        r8.append(r6);
        r8.setSpan(new ForegroundColorSpan(r7), 0, r6.length(), 17);
        MenuItem r9 = new MenuItem();
        r9.spannableText = r8;
        r9.text = null;
        return r9;
    }
}
