package com.lynx.devtool.helper;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.event.EventsListener;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UITreeHelper {
    private static final String TAG = null;
    private WeakReference<LynxUIOwner> mUIOwner;

    public UITreeHelper() {
    }

    public float[] getRectToWindow() {
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        WeakReference<LynxUIOwner> r1 = this.mUIOwner;
        if (r1 == null) goto L5;
        LynxUIOwner r2 = r1.get();
    L6:
        if (r2 != null) goto L8;
    L13:
        return r0;
    L8:
        if (r2.getRootSign() == (-1)) goto L13;
        LynxBaseUI r3 = r2.getNode(r2.getRootSign());
        if (r3 == null) goto L13;
        Rect r4 = r3.getRectToWindow();
        r0[0] = r4.left;
        r0[1] = r4.top;
        r0[2] = r4.width();
        r0[3] = r4.height();
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    static {
        TAG = "UITreeHelper";
    }

    public String getLynxUITree() {
        WeakReference<LynxUIOwner> r0 = this.mUIOwner;
        if (r0 == null) goto L5;
        LynxUIOwner r1 = r0.get();
    L7:
        if (r1 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        UIBody r2 = r1.getRootUI();
        if (r2 != null) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        return getJsonFromMap(getLynxUITreeRecursive(r2)).toString();
    L15:
        LLog.e(TAG, "UITree: getLynxUITree fail");
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r1 = null;
        goto L7
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_devtool_helper_UITreeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private static HashMap<String, Object> getEditablePropertyValueOfUI(LynxBaseUI r9) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("border", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r9.getBorderTopWidth()), Integer.valueOf(r9.getBorderRightWidth()), Integer.valueOf(r9.getBorderBottomWidth()), Integer.valueOf(r9.getBorderLeftWidth())})));
        r0.put("margin", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r9.getMarginTop()), Integer.valueOf(r9.getMarginRight()), Integer.valueOf(r9.getMarginBottom()), Integer.valueOf(r9.getMarginLeft())})));
        r0.put("frame", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r9.getOriginLeft()), Integer.valueOf(r9.getOriginTop()), Integer.valueOf(r9.getWidth()), Integer.valueOf(r9.getHeight())})));
        r0.put(LynxUIOverlay.PROP_VISIBLE, Boolean.valueOf(r9.getVisibility()));
        return r0;
    }

    private static JSONObject getJsonFromMap(Map<String, Object> r5) throws JSONException {
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof Map) == false) goto L8;
        r3 = getJsonFromMap((Map) r3);
    L8:
        r0.put(r2, r3);
        goto L4
    L9:
        return r0;
    }

    public static String getLynxFastbotTweakTree(LynxView r2) {
        if (r2 != null) goto L5;
    L16:
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (r2.getLynxContext() == null) goto L16;
        if (r2.getLynxContext().getLynxUIOwner() == null) goto L16;
        UIBody r3 = r2.getLynxContext().getLynxUIOwner().getRootUI();
        if (r3 != null) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        return getJsonFromMap(getLynxFastbotTweakTreeRecursive(r3)).toString();
    L15:
        LLog.e(TAG, "UITree: getLynxUITree fail");
        goto L16
    }

    private static Map<String, Object> getLynxFastbotTweakTreeRecursive(LynxBaseUI r3) {
        HashMap r0 = new HashMap();
        r0.put("id", Integer.valueOf(r3.getSign()));
        r0.put("class", r3.getClass().getName());
        HashMap<String, Object> r1 = getEditablePropertyValueOfUI(r3);
        HashMap<String, Object> r2 = getReadPropertyValueOfUI(r3);
        r0.putAll(r1);
        r0.putAll(r2);
        ArrayList r4 = new ArrayList();
        Iterator<LynxBaseUI> r5 = r3.getChildren().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(getLynxFastbotTweakTreeRecursive(r5.next()));
        goto L4
    L6:
        r0.put("children", new JSONArray(r4));
        return r0;
    }

    private Map<String, Object> getLynxUITreeRecursive(LynxBaseUI r6) {
        HashMap r0 = new HashMap();
        r0.put(EasyGoDbTable.Server.NAME, r6.getClass().getName());
        r0.put("id", Integer.valueOf(r6.getSign()));
        r0.put("tagName", r6.getTagName());
        r0.put("nodeIndex", Integer.valueOf(r6.getNodeIndex()));
        r0.put("props", r6.getProps().toJSONObject());
        if (r6.getAccessibilityLabel() != null) goto L5;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.put("label", r1);
        r0.put("frame", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r6.getOriginLeft()), Integer.valueOf(r6.getOriginTop()), Integer.valueOf(r6.getWidth()), Integer.valueOf(r6.getHeight())})));
        ArrayList r2 = new ArrayList();
        Iterator<LynxBaseUI> r7 = r6.getChildren().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r2.add(getLynxUITreeRecursive(r7.next()));
        goto L8
    L10:
        r0.put("children", new JSONArray(r2));
        return r0;
    L5:
        r1 = r6.getAccessibilityLabel().toString();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, Object> getReadPropertyValueOfUI(LynxBaseUI r9) {
        HashMap<String, Object> r0 = new HashMap();
        LynxBaseUI.TransOffset r1 = r9.getTransformValue(0.0f, 0.0f, 0.0f, 0.0f);
        r0.put("locationToScreen", new JSONArray(Arrays.asList(new Float[]{Float.valueOf(r1.left_top[0]), Float.valueOf(r1.left_top[1]), Float.valueOf(r1.right_bottom[0]), Float.valueOf(r1.right_bottom[1])})));
        r0.put("clickable", Boolean.valueOf(r9.isClickable()));
        r0.put("long-clickable", Boolean.valueOf(r9.isLongClickable()));
        r0.put("scrollable", Boolean.valueOf(r9.isScrollable()));
        r0.put("focusable", Boolean.valueOf(r9.isFocusable()));
        Map<String, EventsListener> r2 = r9.getEvents();
        if (r2 == null) goto L25;
        HashMap r3 = new HashMap();
        Iterator<EventsListener> r4 = r2.values().iterator();
    L6:
        if (r4.hasNext() == false) goto L23;
        EventsListener r5 = r4.next();
        String r6 = r5.name;
        String r7 = r5.type;
        if (r7 == null) goto L22;
        if (r7.equals("bindEvent") == false) goto L13;
        r6 = "bind" + r6;
        goto L22
    L13:
        if (r5.type.equals("catchEvent") == false) goto L16;
        r6 = "catch" + r6;
        goto L22
    L16:
        if (r5.type.equals("capture-bindEvent") == false) goto L19;
        r6 = "capture-bind" + r6;
        goto L22
    L19:
        if (r5.type.equals("capture-catchEvent") == false) goto L21;
        r6 = "capture-catch" + r6;
        goto L22
    L21:
        r6 = r5.type + r6;
    L22:
        r3.put(r6, r5.functionName);
        goto L6
    L23:
        r0.put("events", r3);
    L25:
        if ((r9 instanceof FlattenUIText) == false) goto L32;
        FlattenUIText r8 = (FlattenUIText) r9;
        if (r8.getText() == null) goto L29;
        String r10 = r8.getText().toString();
    L30:
        r0.put("text", r10);
    L39:
        if (r9.isFlatten() == true) goto L41;
    L43:
        View r11 = ((LynxUI) r9).getView();
    L44:
        r0.put("lynx-test-tag", r9.getTestID());
        if (r11 != null) goto L48;
        LLog.e(TAG, "getReadPropertyValueOfUI: view is null");
        return r0;
    L48:
        r0.put("activated", Boolean.valueOf(r11.isActivated()));
        r0.put("alpha", Float.valueOf(r11.getAlpha()));
        r0.put("has-window-focus", Boolean.valueOf(r11.hasWindowFocus()));
        if (r9.isScrollable() == true) goto L51;
    L70:
        return r0;
    L51:
        if (r11.canScrollHorizontally(-1) == false) goto L53;
        String r12 = "left ";
    L55:
        if (r11.canScrollHorizontally(1) == false) goto L57;
        String r13 = "right ";
    L59:
        if (r11.canScrollVertically(-1) == false) goto L61;
        String r14 = "up ";
    L63:
        if (r11.canScrollVertically(1) == false) goto L65;
        String r15 = "down ";
    L66:
        String r16 = r12 + r13 + r14 + r15;
        if (r16 == NameKeys.UnloadStrategy_No_Strategy) goto L69;
        r16 = r16.substring(0, r16.length() - 1);
    L69:
        r0.put("scroll-direction", r16);
        goto L70
    L65:
        r15 = NameKeys.UnloadStrategy_No_Strategy;
        goto L66
    L61:
        r14 = NameKeys.UnloadStrategy_No_Strategy;
        goto L63
    L57:
        r13 = NameKeys.UnloadStrategy_No_Strategy;
        goto L59
    L53:
        r12 = NameKeys.UnloadStrategy_No_Strategy;
        goto L55
    L41:
        if (r9.getDrawParent() == null) goto L43;
        r11 = ((LynxUI) r9.getDrawParent()).getView();
        goto L44
    L29:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
        goto L30
    L32:
        if ((r9 instanceof UIText) == false) goto L39;
        UIText r17 = (UIText) r9;
        if (((AndroidText) r17.getView()).getText() == null) goto L36;
        String r18 = ((AndroidText) r17.getView()).getText().toString();
    L37:
        r0.put("text", r18);
        goto L39
    L36:
        r18 = NameKeys.UnloadStrategy_No_Strategy;
        goto L37
    }

    public void attachLynxUIOwner(LynxUIOwner r2) {
        this.mUIOwner = new WeakReference(r2);
    }

    public String getUINodeInfo(int r9) {
        new String();
        WeakReference<LynxUIOwner> r4 = this.mUIOwner;
        if (r4 == null) goto L5;
        LynxUIOwner r5 = r4.get();
    L7:
        if (r5 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        LynxBaseUI r10 = r5.getNode(r9);
        if (r10 != null) goto L19;
        return NameKeys.UnloadStrategy_No_Strategy;
    L19:
        HashMap r6 = new HashMap();     // Catch: JSONException -> L17
        r6.put("id", Integer.valueOf(r10.getSign()));     // Catch: JSONException -> L17
        r6.put("isFlatten", Boolean.valueOf(r10.isFlatten()));     // Catch: JSONException -> L17
        r6.put("editableProps", getEditablePropertyValueOfUI(r10));     // Catch: JSONException -> L17
        r6.put("readonlyProps", getReadPropertyValueOfUI(r10));     // Catch: JSONException -> L17
        HashMap r7 = new HashMap();     // Catch: JSONException -> L17
        r7.put(EasyGoDbTable.Server.NAME, r10.getClass().getName());     // Catch: JSONException -> L17
        r7.put("readonlyProps", getAllPropertyAndValues(r10, "ui"));     // Catch: JSONException -> L17
        r6.put("ui", r7);     // Catch: JSONException -> L17
        if (r10.isFlatten() == true) goto L15;
        LynxUI r11 = (LynxUI) r10;     // Catch: JSONException -> L17
        HashMap r1 = new HashMap();     // Catch: JSONException -> L17
        r1.put(EasyGoDbTable.Server.NAME, r11.getView().getClass().getName());     // Catch: JSONException -> L17
        r1.put("readonlyProps", getAllPropertyAndValues(r11.getView(), "view"));     // Catch: JSONException -> L17
        r6.put("view", r1);     // Catch: JSONException -> L17
    L15:
        return getJsonFromMap(r6).toString();
    L17:
        LLog.e(TAG, "UITree: getUINodeInfo fail!");
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r5 = null;
        goto L7
    }

    public void getViewLocationOnScreen(int[] r4) {
        WeakReference<LynxUIOwner> r0 = this.mUIOwner;
        if (r0 == null) goto L5;
        LynxUIOwner r1 = r0.get();
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.length < 2) goto L20;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.getContext() == null) goto L24;
        LynxView r2 = r1.getContext().getLynxView();
        if (r2 == null) goto L22;
        r2.getLocationOnScreen(r4);
        LynxContext r3 = r2.getLynxContext();
        if (r3 == null) goto L23;
        float r5 = INVOKEVIRTUAL_com_lynx_devtool_helper_UITreeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r3.getResources()).density;
        r4[0] = (int) (r4[0] / r5);
        r4[1] = (int) (r4[1] / r5);
        return;
    L23:
        return;
    L22:
        return;
    L24:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public float[] stringToArrayValue(String r5) {
        String[] r6 = r5.replace(" ", NameKeys.UnloadStrategy_No_Strategy).split(",");     // Catch: Exception -> L5
        return new float[]{CastFloatProtector.parseFloat(r6[0]), CastFloatProtector.parseFloat(r6[1]), CastFloatProtector.parseFloat(r6[2]), CastFloatProtector.parseFloat(r6[3])};
    L5:
        LLog.e(TAG, "UITree Debug:parse frame value string fail");
        return new float[0];
    }

    private HashMap<String, Object> getAllPropertyAndValues(Object r4, String r5) {
        HashMap<String, Object> r0 = new HashMap();
        if (r4 == null) goto L14;
        if (r5 == null) goto L14;
        Class r1 = r4.getClass();
        if (r5.equals("view") == false) goto L9;
        Class r6 = View.class;
    L10:
        getAllDeclaredFieldForCurrentClass(r1, r4, r0);
    L11:
        if (r1 == r6) goto L13;
        r1 = r1.getSuperclass();
        getAllDeclaredFieldForCurrentClass(r1, r4, r0);
        goto L11
    L13:
        return r0;
    L9:
        r6 = LynxBaseUI.class;
    L14:
        LLog.e(TAG, "getAllPropertyAndValues: obj or type is null");
        return r0;
    }

    private int setUIBackgroundColor(LynxBaseUI r4, String r5) {
        String r6 = r5.substring(1);     // Catch: Exception -> L5
        r4.setBackgroundColor(CastIntegerProtector.parseUnsignedInt(r6.substring(6) + r6.substring(0, 6), 16));     // Catch: Exception -> L5
        return 0;
    L5:
        LLog.e(TAG, "UITree Debug:parse color value string fail");
        return -1;
    }

    private int setUIBorder(LynxBaseUI r21, String r22) {
        if (r21 != null) goto L5;
        return -1;
    L5:
        float[] r14 = stringToArrayValue(r22);
        if (r14.length == 0) goto L9;
        r21.setBorderWidth(1, (int) r14[3]);
        r21.setBorderWidth(2, (int) r14[1]);
        r21.setBorderWidth(3, (int) r14[0]);
        r21.setBorderWidth(4, (int) r14[2]);
        r21.updateLayout(r21.getLeft(), r21.getTop(), r21.getWidth(), r21.getHeight(), r21.getPaddingLeft(), r21.getPaddingTop(), r21.getPaddingRight(), r21.getPaddingBottom(), r21.getMarginLeft(), r21.getMarginTop(), r21.getMarginRight(), r21.getMarginBottom(), (int) r14[3], (int) r14[0], (int) r14[1], (int) r14[2], r21.getBound());
        return 0;
    L9:
        return -1;
    }

    private int setUIBorderColor(LynxBaseUI r5, String r6) {
        String r7 = r6.substring(1);     // Catch: Exception -> L5
        int r8 = CastIntegerProtector.parseUnsignedInt(r7.substring(6) + r7.substring(0, 6), 16);     // Catch: Exception -> L5
        r5.setBorderColor(0, Integer.valueOf(r8));     // Catch: Exception -> L5
        r5.setBorderColor(1, Integer.valueOf(r8));     // Catch: Exception -> L5
        r5.setBorderColor(2, Integer.valueOf(r8));     // Catch: Exception -> L5
        r5.setBorderColor(3, Integer.valueOf(r8));     // Catch: Exception -> L5
        return 0;
    L5:
        LLog.e(TAG, "UITree Debug:parse color value string fail");
        return -1;
    }

    private int setUIFrame(LynxBaseUI r3, String r4) {
        if (r3 != null) goto L5;
        return -1;
    L5:
        float[] r5 = stringToArrayValue(r4);
        if (r5.length == 0) goto L9;
        r3.setLeft((int) r5[0]);
        r3.setTop((int) r5[1]);
        r3.setWidth((int) r5[2]);
        r3.setHeight((int) r5[3]);
        return 0;
    L9:
        return -1;
    }

    private int setUIMargin(LynxBaseUI r20, String r21) {
        if (r20 != null) goto L5;
        return -1;
    L5:
        float[] r2 = stringToArrayValue(r21);
        if (r2.length == 0) goto L9;
        int r3 = (int) r2[0];
        int r12 = (int) r2[1];
        int r13 = (int) r2[2];
        int r4 = (int) r2[3];
        r20.updateLayout(r4 + (r20.getLeft() - r20.getMarginLeft()), r3 + (r20.getTop() - r20.getMarginTop()), r20.getWidth(), r20.getHeight(), r20.getPaddingLeft(), r20.getPaddingTop(), r20.getPaddingRight(), r20.getPaddingBottom(), r4, r3, r12, r13, r20.getBorderLeftWidth(), r20.getBorderTopWidth(), r20.getBorderRightWidth(), r20.getBorderBottomWidth(), r20.getBound());
        return 0;
    L9:
        return -1;
    }

    private int setUIVisibility(LynxBaseUI r4, String r5) {
        if (r4 != null) goto L5;
    L16:
        return -1;
    L5:
        if (r4.isFlatten() == true) goto L16;
        if (r5 == null) goto L16;
        LynxUI r6 = (LynxUI) r4;
        if (r5.equals("true") == false) goto L13;
        r6.setVisibility(1);
        return 0;
    L13:
        if (r5.equals("false") == false) goto L16;
        r6.setVisibility(0);
        return 0;
    }

    public void getAllDeclaredFieldForCurrentClass(Class r5, Object r6, Map<String, Object> r7) {
        if (r5 != null) goto L5;
        LLog.e(TAG, "getAllDeclaredFieldForCurrentClass: currentClass is null");
        return;
    L5:
        Field[] r8 = r5.getDeclaredFields();
        int r0 = r8.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        Field r2 = r8[r1];
        r2.setAccessible(true);     // Catch: Exception -> L10
        r7.put(r2.getName(), r2.get(r6).toString());     // Catch: Exception -> L10
    L11:
        r1 = r1 + 1;
    L10:
        LLog.e(TAG, "UITree: getAllDeclaredFieldForCurrentClass fail when getUINodeInfo");
        goto L11
    }

    public int setUIStyle(int r2, String r3, String r4) {
        WeakReference<LynxUIOwner> r0 = this.mUIOwner;
        if (r0 == null) goto L5;
        LynxUIOwner r1 = r0.get();
    L6:
        if (r1 == null) goto L35;
        if (r3 == null) goto L37;
        if (r4 == null) goto L38;
        LynxBaseUI r5 = r1.getNode(r2);
        if (r5 == null) goto L39;
        String r6 = r4.trim();
        if (r3.equals("frame") == false) goto L16;
        return setUIFrame(r5, r6);
    L16:
        if (r3.equals("margin") == false) goto L20;
        return setUIMargin(r5, r6);
    L20:
        if (r3.equals("border") == false) goto L24;
        return setUIBorder(r5, r6);
    L24:
        if (r3.equals(LynxUIOverlay.PROP_VISIBLE) == false) goto L28;
        return setUIVisibility(r5, r6);
    L28:
        if (r3.equals("background-color") == false) goto L32;
        return setUIBackgroundColor(r5, r6);
    L32:
        if (r3.equals("border-color") == true) goto L34;
        return 0;
    L34:
        return setUIBorderColor(r5, r6);
    L39:
        return 0;
    L38:
        return 0;
    L37:
        return 0;
    L35:
        return 0;
    L5:
        r1 = null;
        goto L6
    }
}
