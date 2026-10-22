package com.obric.cae.smartBluetooth.btaware;

import android.aimedia.a;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GattCarInfo {
    private BluetoothGatt mBluetoothGatt;
    private int mCarRssiAvg20;
    private int mCurrentRssi;
    private BluetoothDevice mDevice;
    private boolean mInCar;
    private List<Integer> mInCarRssi20List;
    private boolean mIsConnected;
    private int mKalmanHitRssi;
    private int mLastRssi;
    private String mPackageName;
    private int mRssiAvg10;
    private List<Integer> mRssiAvg10List;
    private List<Integer> mRssiList;

    public GattCarInfo(BluetoothDevice r8) {
        this.mDevice = r8;
        this.mBluetoothGatt = null;
        this.mIsConnected = false;
        this.mLastRssi = 0;
        this.mCurrentRssi = 0;
        this.mPackageName = "";
        this.mRssiList = new ArrayList();
        this.mRssiAvg10List = new ArrayList();
        this.mRssiAvg10 = Integer.MIN_VALUE;
        this.mInCarRssi20List = new ArrayList(20);
        this.mCarRssiAvg20 = Integer.MIN_VALUE;
        this.mKalmanHitRssi = Integer.MIN_VALUE;
        this.mInCar = false;
    }

    public void addInCarRssiValue(int r8) {
        if (this.mInCarRssi20List.size() < 20) goto L5;
        return;
    L5:
        this.mInCarRssi20List.add(Integer.valueOf(r8));
        if (this.mInCarRssi20List.size() != 20) goto L14;
        Iterator<Integer> r10 = this.mInCarRssi20List.iterator();
        long r11 = 0;
    L9:
        if (r10.hasNext() == false) goto L11;
        r11 = r11 + ((long) r10.next().intValue());
        goto L9
    L11:
        this.mCarRssiAvg20 = Math.round(r11 / 20.0f);
        return;
    }

    public void addRssiValue(int r8) {
        this.mRssiList.add(Integer.valueOf(r8));
        int r10 = this.mRssiList.size();
        if (r10 > 0) goto L5;
        return;
    L5:
        if ((r10 % 10) != 0) goto L13;
        int r11 = r10 - 10;
        int r12 = 0;
    L7:
        if (r11 >= r10) goto L9;
        r12 = r12 + this.mRssiList.get(r11).intValue();
        r11 = r11 + 1;
        goto L7
    L9:
        this.mRssiAvg10List.add(Integer.valueOf(Math.round(r12 / 10.0f)));
        return;
    }

    public void clearRssiList() {
        this.mRssiList.clear();
        this.mRssiAvg10List.clear();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
        return true;
    L5:
        if (r8 != null) goto L7;
        return false;
    L7:
        if (getClass() == r8.getClass()) goto L10;
        return false;
    L10:
        return this.mDevice.equals(((GattCarInfo) r8).mDevice);
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public int getCarRssiAvg20() {
        return this.mCarRssiAvg20;
    }

    public int getCurrentRssi() {
        return this.mCurrentRssi;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public List<Integer> getInCarRssi20List() {
        return this.mInCarRssi20List;
    }

    public int getKalmanHitRssi() {
        return this.mKalmanHitRssi;
    }

    public int getLastRssi() {
        return this.mLastRssi;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getRssiAvg10() {
        return this.mRssiAvg10;
    }

    public List<Integer> getRssiAvg10List() {
        return this.mRssiAvg10List;
    }

    public List<Integer> getRssiList() {
        return this.mRssiList;
    }

    public int getRssiListMean() {
        List<Integer> r8 = this.mRssiList;
        if (r8 != null) goto L5;
        return Integer.MIN_VALUE;
    L5:
        if (r8.isEmpty() == true) goto L16;
        Iterator<Integer> r10 = this.mRssiList.iterator();
        long r11 = 0;
    L9:
        if (r10.hasNext() == false) goto L12;
        r11 = r11 + ((long) r10.next().intValue());
        goto L9
    L12:
        return Math.round(r11 / this.mRssiList.size());
    L16:
        return Integer.MIN_VALUE;
    }

    public int hashCode() {
        return this.mDevice.hashCode();
    }

    public boolean isCarRssiAvg20Ready() {
        if (this.mCarRssiAvg20 == Integer.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isInCar() {
        return this.mInCar;
    }

    public void resetInCarRssiSampling() {
        this.mInCarRssi20List.clear();
        this.mCarRssiAvg20 = Integer.MIN_VALUE;
    }

    public void setBluetoothGatt(BluetoothGatt r8) {
        this.mBluetoothGatt = r8;
    }

    public void setConnected(boolean r8) {
        this.mIsConnected = r8;
    }

    public void setCurrentRssi(int r8) {
        this.mLastRssi = this.mCurrentRssi;
        this.mCurrentRssi = r8;
    }

    public void setDevice(BluetoothDevice r8) {
        this.mDevice = r8;
    }

    public void setInCar(boolean r8) {
        this.mInCar = r8;
    }

    public void setKalmanHitRssi(int r8) {
        this.mKalmanHitRssi = r8;
    }

    public void setLastRssi(int r8) {
        this.mLastRssi = r8;
    }

    public void setPackageName(String r8) {
        this.mPackageName = r8;
    }

    public void setRssiAvg10(int r8) {
        this.mRssiAvg10 = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("GattCarInfo{device=");
        r8.append(this.mDevice.getAddress());
        r8.append(", isConnected=");
        r8.append(this.mIsConnected);
        r8.append(", lastRssi=");
        r8.append(this.mLastRssi);
        r8.append(", currentRssi=");
        r8.append(this.mCurrentRssi);
        r8.append(", rssiAvg10=");
        r8.append(this.mRssiAvg10);
        r8.append(", rssiAvg10ListSize=");
        List<Integer> r10 = this.mRssiAvg10List;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        r8.append(r12);
        r8.append(", kalmanHitRssi=");
        r8.append(this.mKalmanHitRssi);
        r8.append(", inCar=");
        r8.append(this.mInCar);
        r8.append(", carRssiAvg20=");
        r8.append(this.mCarRssiAvg20);
        r8.append(", inCarRssi20ListSize=");
        List<Integer> r13 = this.mInCarRssi20List;
        if (r13 == null) goto L10;
        r11 = r13.size();
    L10:
        r8.append(r11);
        r8.append(", packageName='");
        return a.i(r8, this.mPackageName, "'}");
    L5:
        r12 = r10.size();
        goto L6
    }
}
